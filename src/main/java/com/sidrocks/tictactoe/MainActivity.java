package com.sidrocks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0-X
    //1-0
    boolean gameActive=true;
    int activeplayer=0;
    int [] gamestate={2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 };
    int [][] winingpositions= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTag(View view){
    ImageView img=(ImageView)view;
    int tappedImage=Integer.parseInt(img.getTag().toString());
    if(!gameActive){
        gameReset(view);
    }
    if(gamestate[tappedImage]==2 && gameActive){
        gamestate[tappedImage]=activeplayer;
        img.setTranslationY(-1000f);
        if(activeplayer==0){
            img.setImageResource(R.drawable.x);
            activeplayer=1;
            TextView status=findViewById(R.id.status);
            status.setText("O's turn");
        }
        else{
            img.setImageResource(R.drawable.o);
            activeplayer=0;
            TextView status=findViewById(R.id.status);
            status.setText("X's turn");
        }

    img.animate().translationYBy(1000f).setDuration(300);}
    for(int []winposition:winingpositions){
        if (gamestate[winposition[0]]==gamestate[winposition[1]] && gamestate[winposition[1]]==gamestate[winposition[2]] && gamestate[winposition[0]]!=2){
            String wstr;
            gameActive=false;
            if(gamestate[winposition[0]]==0){
                wstr="X has won";
            }
            else{
                wstr="O has won";
            }
            TextView status=findViewById(R.id.status);
            status.setText(wstr);
        }

    }
    }

    public void gameReset(View view){
        gameActive=true;
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("X's turn");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
