#include <Ethernet.h>
#include <SPI.h>
#include "EmonLib.h"                   // Include Emon Library

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED};

EnergyMonitor sensor;                   // Create an instance

EthernetClient cliente;

void setup()
{  
  Serial.begin(9600);
  
  sensor.current(1, 111.1);             // Current: input pin, calibration.

  if(Ethernet.begin(mac) == 0){
    Serial.println("Shield ethernet não inicialzado!");
  }else{
    Serial.println("Ethernet shield inicializado!");
  }
  Serial.print("IP: ");
  Serial.println(Ethernet.localIP());
}

void loop(){
  double irms = sensor.calcIrms(1480);
  double potencia = irms*220.0;
  double kw = potencia*1000;
  
  Serial.print("Potencia: ");
  Serial.print(potencia);
  Serial.println(" W");         
  Serial.print("Corrente: ");
  Serial.print(irms);
  Serial.println(" A \t");
  Serial.print("kW: ");
  Serial.println(kw);
  Serial.println();
  delay(1000);
  enviarDados(irms, potencia, kw);
}

void enviarDados(double irms, double potencia, double kw){
  cliente.connect("192.168.0.110",9091);
  if(cliente.connected()){
    cliente.print("GET /Arduino/ArduinoServlet?ampers="); cliente.print(irms);
    cliente.print("&potencia="); cliente.print(potencia);
    cliente.print("&kw="); cliente.print(kw);
    cliente.println(" HTTP/1.1");
    cliente.println("Host: 192.168.0.110");
    cliente.println();    

    while(cliente.available()){ char c = cliente.read(); }
    cliente.stop();
    Serial.println("Dados enviados com sucesso!");
  }else{
    Serial.println("Falha na conexão");
  }
}
