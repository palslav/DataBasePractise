package com.tp.pals.databasepractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private EditText emp_id;
    private EditText emp_name;
    private EditText emp_email;
    private EditText emp_id_del;

    private Button bAdd;
    private Button bDelete;
    private Button bDatabase;

    DatabaseActivity dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //emp_id = (EditText) findViewById(R.id.et_EMP_ID);
        emp_name = (EditText) findViewById(R.id.et_EMP_NAME);
        emp_email = (EditText) findViewById(R.id.et_EMP_EMAIL);
        emp_id_del = (EditText) findViewById(R.id.et_Delete);

        bAdd = (Button) findViewById(R.id.b_Add);
        bDelete = (Button) findViewById(R.id.b_Delete);
        bDatabase = (Button) findViewById(R.id.b_Database);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnAddClicked(view);
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnDeleteClicked(view);
            }
        });

        bDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnTaketoDB(view);
            }
        });

        dbHandler = new DatabaseActivity(this, null, null, 1);
        //printDatabase();
    }

    private void OnAddClicked(View view) {
        //String id = emp_id.getText().toString();
        String name = emp_name.getText().toString();
        String email = emp_email.getText().toString();

        Employee emp = new Employee(name, email);
        dbHandler.addEmp(emp);

        Toast toast = new Toast(this);
        toast.makeText(getApplicationContext(), "Emp Added", toast.LENGTH_SHORT).show();

        emp_name.setText("");
        emp_email.setText("");
        //printDatabase();
    }

    private void OnDeleteClicked(View view) {
        String id = emp_id_del.getText().toString();
        dbHandler.deleteEmp(id);

        Toast toast = new Toast(this);
        toast.makeText(getApplicationContext(), "Emp Deleted", toast.LENGTH_SHORT).show();

        emp_id_del.setText("");
        //printDatabase();
    }

    private void OnTaketoDB(View view) {
        Intent i = new Intent(getApplicationContext(), DataBase.class);
        startActivity(i);
    }
}
