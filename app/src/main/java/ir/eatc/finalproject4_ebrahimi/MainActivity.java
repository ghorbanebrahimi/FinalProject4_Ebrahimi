package ir.eatc.finalproject4_ebrahimi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCallForm;
    CheckBox chkEsm,chkShahr;
    String choice;
    TextView txtinformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  txttst=(TextView)findViewById(R.id.txtTest);
        btnCallForm=(Button)findViewById(R.id.btngotoform);
        chkEsm=(CheckBox) findViewById(R.id.chkname);
        chkShahr=(CheckBox)findViewById(R.id.chkcity);
        txtinformation=(TextView)findViewById(R.id.txtinfo);

     btnCallForm.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (chkEsm.isChecked()) {
                 choice= "esm";
              //   txttst.setText("Hi");
             }
             if (chkShahr.isChecked()){
                 choice= "shahr";
             }


             Intent i=new Intent(MainActivity.this,FormActivity.class);
             i.putExtra("entekhab" ,choice);
             startActivityForResult(i,1);
         }
     });

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        String info=data.getStringExtra("typedInfo");
        txtinformation.setVisibility(View.VISIBLE);
        txtinformation.setText(info);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnu=getMenuInflater();
        mnu.inflate(R.menu.ebrahimi_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.aboutEbrahimi:
                Toast.makeText(MainActivity.this,"تهیه شده توسط: قربان ابراهیمی",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tamasEbrahimi:
                Toast.makeText(MainActivity.this,"شماره تماس: 09143134695" ,Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
