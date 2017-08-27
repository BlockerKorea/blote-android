package blote.org.bloteAndroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        actionBar = getSupportActionBar();
        actionBar.hide();

        Button btn1 = (Button)findViewById(R.id.btn_about);
        Button btn2 = (Button)findViewById(R.id.btn_login);
        Button btn3 = (Button)findViewById(R.id.btn_vote);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MenuActivity.this,MainActivity.class);
                it.putExtra("link","about");
                startActivity(it);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MenuActivity.this,MainActivity.class);
                it.putExtra("link","login");
                startActivity(it);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();

            }
        });
    }

    void show()
    {
        final EditText edittext = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Blote.me 투표하기");
        builder.setMessage("투표의 고유 키값을 입력해주세요.");
        builder.setView(edittext);
        builder.setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent it = new Intent(MenuActivity.this,MainActivity.class);
                        it.putExtra("link","survey/"+edittext.getText().toString());
                        startActivity(it);
                        Toast.makeText(getApplicationContext(),edittext.getText().toString() , Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

}
