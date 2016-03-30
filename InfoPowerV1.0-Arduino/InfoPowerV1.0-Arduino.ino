#include <Ethernet.h>
#include <SPI.h>                        //Inclui as duas bibliotecas de conexão remota
#include "EmonLib.h"                   //Inclui a biblioteca do sensor

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED}; //Definição padrão de MAC para o EthernetShield

EnergyMonitor sensor;                   // Cria a instancia do sensor

EthernetClient cliente;

void setup()
{  
  Serial.begin(9600);     //Inicial a serial do arduino
  
  sensor.current(1, 111.1);           //Define o pino "1" como o pino que vai receber os dados e 111.1 é a calibração do sensor 100A/50mA para leitura mais aproximada possivel

  //Testa o MAC pra saber se o ethernet sera inicializado
  if(Ethernet.begin(mac) == 0){
    Serial.println("Shield ethernet não inicialzado!");
  }else{
    Serial.println("Ethernet shield inicializado!");
  }
  //Mostra o IP do ethernet na serial
  Serial.print("IP: ");
  Serial.println(Ethernet.localIP());
}

void loop(){
  double irms = sensor.calcIrms(1480);  //Calculo padrão para leitura de irms(Amper)
  double potencia = irms*220.0;         //Calculo de potencia (potencia = ampers * voltagem)
  
  Serial.print("Potencia: ");
  Serial.print(potencia);
  Serial.println(" W");         
  Serial.print("Corrente: ");
  Serial.print(irms);
  Serial.println(" A \t");
  
  enviarDados(irms, potencia);
 
  delay(1000);   //Agaurda 1 segundo para continuar.
}
 
void enviarDados(double irms, double potencia){
  //Define o IP e porta de conexão remota
  cliente.connect("192.168.0.110",9091);
  //Se tiver conexão com o caminho especificado ele faz um GET com os valores irms,potencia e kw
  if(cliente.connected()){
    cliente.print("GET /InfoPower/ArduinoServlet?ampers="); cliente.print(irms);
    cliente.print("&potencia="); cliente.print(potencia);
    cliente.println(" HTTP/1.1");
    cliente.println("Host: 192.168.0.110");
    cliente.println();    

    //Lê a resposta dada pelo servidor e a ignora
    while(cliente.available()){ char c = cliente.read(); }
    
    cliente.stop();//Para a conexão
    
    Serial.println("Dados enviados com sucesso!");//Confirma atravez da serial que os dados foram enviados
  }else{
    Serial.println("Falha na conexão");//Caso não consiga se conectar com o caminho especificado imprime que ouve falha da conexão
  }
}
