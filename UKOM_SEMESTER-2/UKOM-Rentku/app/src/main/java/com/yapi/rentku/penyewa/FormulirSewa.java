package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.profesi.BajuProfesi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormulirSewa extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvawal;
    private TextView tvakhir;
    private Button btnsewaa;
    private Button btnsewab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_sewa);

        //kalender
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        //deklarasi
        tvawal = (TextView) findViewById(R.id.tvawal);
//        tvakhir = (TextView) findViewById(R.id.tvakhir);
        btnsewaa = (Button) findViewById(R.id.btnsewaa);
//        btnsewab = (Button) findViewById(R.id.btnsewab);

        btnsewaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialoga();
            }
        });
//
//        btnsewab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDateDialogb();
//            }
//        });

    }

    private void showDateDialoga() {
        //tglskrng
        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvawal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//
//
//    //tampil
//        datePickerDialog.show();
//}
//
//    private void showDateDialogb(){
//        //tglskrng
//        Calendar newCalendar = Calendar.getInstance();
//
//        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year, monthOfYear, dayOfMonth);
//
//                tvakhir.setText(dateFormatter.format(newDate.getTime()));
//            }
//        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//
//
//        //tampil
//        datePickerDialog.show();
//    }

//        public void btnseewa (View view){
//            Intent intent = new Intent(FormulirSewa.this, Sewaanku.class);
//            startActivity(intent);
//        }
//
//        public void btnkembali (View view){
//            Intent intent = new Intent(FormulirSewa.this, BajuProfesi.class);
//            startActivity(intent);
//        }
//    }
    }
}