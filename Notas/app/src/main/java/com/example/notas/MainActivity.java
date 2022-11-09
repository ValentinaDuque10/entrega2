package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEstudiantes,editTextNota1,editTextNota2,editTextNota3,editTextNota4;
    private TextView textViewNotaFinal,textViewReprobado;
    private Button buttonIngresarE,buttonCalcular;
    RadioButton valor1,valor2,valor3,valor4;

    private double nota1,nota2,nota3,nota4,notaFinal;
    private int numRepr=0;
    public int numEstudiantes;
    public double porcentaje1,porcentaje2,porcentaje3,porcentaje4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEstudiantes=(EditText) findViewById(R.id.editTextEstudiantes);
        editTextNota1=(EditText) findViewById(R.id.editTextNota1);
        editTextNota2=(EditText) findViewById(R.id.editTextNota2);
        editTextNota3=(EditText) findViewById(R.id.editTextNota3);
        editTextNota4=(EditText) findViewById(R.id.editTextNota4);
        valor1=(RadioButton) findViewById(R.id.radioButtonNot1);
        valor2=(RadioButton) findViewById(R.id.radioButtonNot2);
        valor3=(RadioButton) findViewById(R.id.radioButtonNot3);
        valor4=(RadioButton) findViewById(R.id.radioButtonNot4);
        textViewReprobado=(TextView) findViewById(R.id.textViewReprobado);
        textViewNotaFinal=(TextView) findViewById(R.id.textViewNotaFinal);
        buttonIngresarE=(Button) findViewById(R.id.buttonIngresarE);
        buttonCalcular=(Button) findViewById(R.id.buttonCalcular);


    }

    public void porcentajes(View view){
        boolean opcion=((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioButtonNot1:
                if(opcion)
                    porcentaje1=0.20;
                    break;
            case R.id.radioButtonNot2:
                if(opcion)
                    porcentaje2=0.30;
                break;
            case R.id.radioButtonNot3:
                if(opcion)
                    porcentaje3=0.15;
                break;
            case R.id.radioButtonNot4:
                if(opcion)
                    porcentaje4=0.35;
                break;
        }
    }

    public void CantidadEstudiante(View view){
        numEstudiantes=Integer.parseInt(editTextEstudiantes.getText().toString());
    }

    private void ConvertirN(){
        nota1=Double.parseDouble(editTextNota1.getText().toString());
        nota2=Double.parseDouble(editTextNota2.getText().toString());
        nota3=Double.parseDouble(editTextNota3.getText().toString());
        nota4=Double.parseDouble(editTextNota4.getText().toString());

    }

    private boolean Valido(double val){
        if(val>0 && val<=5){
            return true;
        }else{
            return false;
        }
    }

    private boolean Validar(int val2){
        if(val2>0){
            return true;
        }else{
            return false;
        }
    }

    public void Calcular(View view){
        ConvertirN();

        if(Valido(nota1)&& Valido(nota2)&&Valido(nota3)&& Valido(nota4)&&Validar(numEstudiantes)){
            nota1 =(nota1*nota1);
            nota2 =(nota2*nota2);
            nota3 =(nota1*nota3);
            nota4 =(nota1*nota4);

            notaFinal=nota1+nota2+nota3+nota4;
            textViewNotaFinal.setText(String.valueOf(notaFinal));

            numEstudiantes--;

            if(notaFinal<3){
                numRepr=numRepr+1;
            }
        }else{
            if (!Valido(nota1) || !Valido(nota2) || !Valido(nota3) || !Valido(nota4)) {
                Toast.makeText(this, "La nota no es valida", Toast.LENGTH_SHORT).show();

            }
            if (numEstudiantes==0){
                Toast.makeText(this, "La cantidad de estudiantes es 0", Toast.LENGTH_SHORT).show();
            }
            textViewReprobado.setText(String.valueOf(numRepr));
        }
    }

}