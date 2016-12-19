/*
 * Projeto: Economy Energy
 * Autor: Grupo InfoPower
 * Data: 20/11/2016
 * Versão: v1.8
 * Descrição: O Arduino recebe uma requisição HTTP e retorna um JSON que é tratado no HTML com Javascript para exibir na tela, acrescentando a opção de apagar luzaes e desligar tomadas.
 * Versão 1.8 trás primeiro teste de acionamento de led com relê
 */
    
#include <SPI.h>                
#include <Ethernet.h>           //inclusão das duas bibliotecas para uso do ethernet Shield
#include "EmonLib.h"                   //Inclui a biblioteca do sensor

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED}; // configuração de mac padrão ethernet

IPAddress ip(192,168,0,130);
IPAddress gateway(192,168,0,1);
IPAddress subnet(255,255,255,0); //definição de ip, gateway e subnet para criação de um server

EthernetServer servidor(9091); // definição da porta do server

EnergyMonitor sensor;                   // Cria a instancia do sensor

double ampers = 0;
double potencia = 0;
double kw = 0;
int pin = 7;
String readString;

void setup(){
  Serial.begin(9600); // inicia o arduino
  Ethernet.begin(mac,ip,gateway,subnet); // inicia o server
  Serial.println("Server ativo no IP: ");
  Serial.print(Ethernet.localIP());
  servidor.begin();
  
  sensor.current(1, 154.4);        //Define o pino "1" como o pino que vai receber os dados e 154.4 é a calibração do sensor 100A/50mA para leitura mais aproximada possivel

  pinMode(pin, OUTPUT); 
}

void loop(){
  EthernetClient cliente = servidor.available(); // define um cliente para o uso do server
  
   ampers = sensor.calcIrms(1480);  //Calculo padrão para leitura de irms(Amper)
   potencia = ampers*220.0;         //Calculo de potencia (potencia = ampers * voltagem)
   kw = (((potencia)/1000.0) * 1.0/3600.0); //Calculo do kw
  
  enviarServlet(kw); // chama o metodo de envio de dados pro servlet
  printPage(); //Chama o metodo para ligar e desligar o relê
  
  if(cliente){
    boolean continua = true;
    String linha = "";

    while(cliente.connected()){
      if(cliente.available()){
        char c = cliente.read();
        linha.concat(c);
            
        if(c == '\n' && continua){
          
          cliente.println("HTTP/1.1 200 OK");
          // IMPORTANTE, ISSO FAZ O ARDUINO RECEBER REQUISIÇÃO AJAX DE OUTRO SERVIDOR E NÃO APENAS LOCAL.
          cliente.println("Content-Type: text/javascript");
          cliente.println("Access-Control-Allow-Origin: *");
          cliente.println();          
         
            //valores enviados para a solicitação ajax
            cliente.print("dados({ ampers : ");
            cliente.print(ampers);
            cliente.print(", potencia :  ");
            cliente.print(potencia);
            cliente.print(", kw :  ");
            cliente.print(kw,DEC);
            cliente.print("})");
                  
          break;
        }
        if(c == '\n') { continua = true; }
        else if (c != '\r') { continua = false; }
      }
    }
     delay(1);
     cliente.stop();
  }
}

void enviarServlet(double kw){
 EthernetClient clienteServlet; //instancia um cliente para envio de dados via requisição GET para o servlet
  
  clienteServlet.connect("192.168.0.100",9090);// define o ip e porta ao qual vai ser enviada a requisição
  
  if (clienteServlet.connected()) { //se o server encontrar o ip e a porta livre ele envia a requisição.
    clienteServlet.print("GET /InfoPower/ArduinoServlet?");
    clienteServlet.print("kw=");
    clienteServlet.print(kw,DEC);
    clienteServlet.println(" HTTP/1.1");
    clienteServlet.println("Host: 192.168.0.100");
    clienteServlet.println();
    

    while (clienteServlet.available()) {// lê a resposta e ignora
      char c = clienteServlet.read();
    }

    delay(100);
    clienteServlet.stop();
    Serial.println("Dados enviados!");
  } else {
    Serial.println("Falha na conexão.");
  }
}

void printPage(){
  EthernetServer server(9092);
 EthernetClient cliente = server.available();
  if (cliente) {
    while (cliente.connected()) {
      if (cliente.available()) {
        char c = cliente.read();
  
        if (readString.length() < 100) {
          readString += c;             
        }
 
        if (c == '\n') {
          cliente.println("HTTP/1.1 200 OK");
          cliente.println("Content-Type: text/html");
          cliente.println();
           
          cliente.println("<HTML>");
          cliente.println("<BODY>");
          cliente.println("<H1>Acende LED</H1>");
          cliente.println("<hr />");
          cliente.println("<br />");
           
          cliente.println("<a href=\"/?ledon\">Ligar o led</a>");
          cliente.println("<a href=\"/?ledoff\">Desligar o led</a><br />");   
           
          cliente.println("</BODY>");
          cliente.println("</HTML>");
           
          delay(1);
          cliente.stop();
           
          if(readString.indexOf("?ledon") > 0)
          {
            digitalWrite(pin, LOW);
          }
          else {
            if(readString.indexOf("?ledoff") > 0)
            {
              digitalWrite(pin, HIGH);
            }
          }
          readString="";    
        }
      }
    }
  }
}
