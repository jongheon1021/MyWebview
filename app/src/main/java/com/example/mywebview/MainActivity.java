package com.example.mywebview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editUrl;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editUrl);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());


        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnGoNaver).setOnClickListener(this);
        findViewById(R.id.btnGoGoogle).setOnClickListener(this);
        findViewById(R.id.btnBack).setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.menu1:
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("안녕하세요")
                        .setPositiveButton("확인",null)
                        .setIcon(R.drawable.googlelogo)
                        .setMessage("내용을 써봅시다.")
                        .show();
                break;
            case R.id.menu2:
                View dlgView = View.inflate(this, R.layout.profile ,null);

                AlertDialog.Builder dlg2 = new AlertDialog.Builder(this);
                dlg2.setTitle("안녕하세요");
                dlg2.setView(dlgView);
                dlg2.setNegativeButton("취소",null);
                dlg2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText id = dlgView.findViewById(R.id.dlg_id);
                        String nickname = id.getText().toString().trim();
                        if(nickname.length()>0)
                            setTitle(id.getText().toString()+"의 검색기");
                    }
                });
                dlg2.show();
                break;
            case R.id.menu3:

                finish();
            case R.id.menu4:
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"TEST" , Toast.LENGTH_LONG).show();
        switch(v.getId()){
            case R.id.btnClear:
                editUrl.setText("");
                break;
            case R.id.btnGoNaver:
                webView.loadUrl("https://search.naver.com/search.naver?query="+editUrl.getText().toString());
                break;
            case R.id.btnGoGoogle:
                webView.loadUrl("https://www.google.com/search?q="+editUrl.getText().toString());
                break;
            case R.id.btnBack:
                webView.goBack();
                break;
        }
    }
}