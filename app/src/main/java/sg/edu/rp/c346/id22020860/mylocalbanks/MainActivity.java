package sg.edu.rp.c346.id22020860.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView DBS;
    TextView OCBC;
    TextView UOB;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.dbs);
        OCBC = findViewById(R.id.ocbc);
        UOB = findViewById(R.id.uob);


        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText(R.string.dbs);
            OCBC.setText(R.string.ocbc);
            UOB.setText(R.string.uob);
            return true;
        } else if (id == R.id.chineseSelection) {
            DBS.setText(R.string.Cdbs);
            OCBC.setText(R.string.Cocbc);
            UOB.setText(R.string.Cuob);
            return true;

        }
            return super.onOptionsItemSelected(item);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == DBS){
            wordClicked = "dbs";
        }
        else if(v == OCBC){
            wordClicked = "ocbc";
        }
        else if(v == UOB){
            wordClicked = "uob";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("dbs")) {
            int id = item.getItemId();
            if (id == R.id.bankWebsite) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
                return true;

            } else if (id == R.id.bankContactNumber) { //check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
        }
        else if(wordClicked.equalsIgnoreCase("ocbc")) {
            int id = item.getItemId();
            if (id == R.id.bankWebsite) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;

            } else if (id == R.id.bankContactNumber) { //check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
        }
        else if(wordClicked.equalsIgnoreCase("uob")) {
            int id = item.getItemId();
            if (id == R.id.bankWebsite) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.uob.com.sg"));
                startActivity(intentWeb);
                return true;

            } else if (id == R.id.bankContactNumber) { //check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item);
    }
}