int       cont            = 0;
int 	    contBtn		      = 0;
int aux = 0;
int auxBtn = 0;
int ligado = 0;
const int Led1            = 7;
const int Led2            = 6;
const int Led3            = 5;
const int btn             = 2;
const int sensor          = 4;
int       sensorLumiPin   = 0;
int       sensorLumiValue = 0;
int       valorBtn        = 0;
bool      valorSensor;
long previousMillis       = 0;
long previousMillisBtn    = 0;
long redLedInterval       = 2000;
long BtnInterval          = 6000;

void setup()
{
  //INPUT
  pinMode(btn, INPUT);
  pinMode(sensor, INPUT);
  
  //OUTPUT
  pinMode(Led1, OUTPUT);
  pinMode(Led2, OUTPUT);
  pinMode(Led3, OUTPUT);
  
  //comunicação serial
  Serial.begin(9600);
}

void loop()
{
  //Obtem tempo atual
  unsigned long currentMillis = millis();
  
  // le o valor do botão
  valorBtn = digitalRead(btn);
  if(valorBtn == 0){
  	previousMillisBtn = currentMillis+BtnInterval;
    if(contBtn == 3){
    	contBtn = 0;
    }else{
    	contBtn++;
    }
  }
  
  // read the value from the sensor:
  sensorLumiValue = analogRead(sensorLumiPin);    
  if(sensorLumiValue <= 230){
    cont = 3;
  } else if(sensorLumiValue > 230 && sensorLumiValue <=400){
    cont = 2;
  } else if(sensorLumiValue > 400 && sensorLumiValue <= 600){
    cont = 1;
  } else if(sensorLumiValue > 600){
    cont = 0;
  }
  
  
  //verifica o sensor e liga os leds
  valorSensor = digitalRead(sensor);
  
  if((currentMillis+BtnInterval) - previousMillisBtn > BtnInterval){
    if(valorSensor == 1 && aux != cont){
      if(cont == 1 || cont == 2 || cont == 3){
          previousMillis = currentMillis+redLedInterval;
          ligado = 1;
      }
      if(cont == 0){
        digitalWrite(Led1, LOW);
        digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
        Serial.println("1-LOW");
        Serial.println("2-LOW");
        Serial.println("3-LOW");
      }else if(cont == 1){
        digitalWrite(Led1, HIGH);
        Serial.println("1-HIGH");
      } else if(cont == 2){
        digitalWrite(Led1, HIGH);
        digitalWrite(Led2, HIGH);
        Serial.println("1-HIGH");
        Serial.println("2-HIGH");
      }else if(cont == 3){
        digitalWrite(Led1, HIGH);
        digitalWrite(Led2, HIGH);
        digitalWrite(Led3, HIGH);
        Serial.println("1-HIGH");
        Serial.println("2-HIGH");
        Serial.println("3-HIGH");
      }
    }else if((currentMillis+redLedInterval) - previousMillis > redLedInterval){
      if(ligado == 1){
        digitalWrite(Led1, LOW);
        digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
        Serial.println("1-LOW");
        Serial.println("2-LOW");
        Serial.println("3-LOW");
        ligado = 0;
      }
    }
  }else{
    if(auxBtn != contBtn){
      if(contBtn == 0){
        digitalWrite(Led1, LOW);
        digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
        Serial.println("1-LOW");
        Serial.println("2-LOW");
        Serial.println("3-LOW");
      }else if(contBtn == 1){
        digitalWrite(Led1, HIGH);
        Serial.println("1-HIGH");
      }else if(contBtn == 2){
        digitalWrite(Led2, HIGH);
        Serial.println("2-HIGH");
      }else if(contBtn == 3){
        digitalWrite(Led3, HIGH);
        Serial.println("3-HIGH");
      }
    }
  }

  delay(150);  
}