int cont = 0;
int btnValor = 0;
int aux = 0;
const int led1 = 7;
const int led2 = 6;
const int led3 = 5;
const int btn = 12;

void setup() {
  //INPUT
  pinMode(btn, INPUT);

  //OUTPUT
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);

  //comunicação serial
  Serial.begin(9600);
}

void loop() {
  btnValor = digitalRead(btn);
  if(btnValor == 0){
    if(cont == 3){
      cont = 0;
    }else{
      cont++;
    }
  }

  if(aux != cont){
  if(cont == 0){
      digitalWrite(led1, LOW);
      Serial.println("1-LOW");
      digitalWrite(led2, LOW);
      Serial.println("2-LOW");
      digitalWrite(led3, LOW);
      Serial.println("3-LOW");
  }else if(cont == 1){
      digitalWrite(led1, HIGH);
      Serial.println("1-HIGH");
  } else if(cont == 2){
      digitalWrite(led2, HIGH);
      Serial.println("2-HIGH");
  }else if(cont == 3){
      digitalWrite(led3, HIGH);
      Serial.println("3-HIGH");
  }
  aux = cont;
  }
  delay(200);
}
