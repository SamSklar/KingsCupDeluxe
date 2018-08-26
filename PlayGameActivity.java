package com.example.samsklar.kingscupdeluxe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;


public class PlayGameActivity extends AppCompatActivity {

    int[] deck;
    ArrayList<Integer> shuffledDeck;
    int index = 0;
    int kingCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        Button img = (Button) findViewById(R.id.cardImage);

        shuffledDeck = shuffleDeck();
        deck = createDeck();

        img.setBackgroundResource(deck[shuffledDeck.get(index)]);
        if(shuffledDeck.get(0)/4 == 12) kingCount++;

    }

    public ArrayList<Integer> shuffleDeck(){
        ArrayList<Integer> standard = new ArrayList<Integer>();
        for(int i = 0; i < 52; i++){
            standard.add(i);
        }

        ArrayList<Integer> randomOrder = new ArrayList<Integer>();

        Random gen = new Random();
        while(standard.size() > 0){
            int index = gen.nextInt(standard.size());
            randomOrder.add(standard.remove(index));
        }

        return randomOrder;
    }


    public void cardClicked(View view) {
        Button img = (Button) findViewById(R.id.cardImage);
        img.setBackgroundColor(Color.WHITE);


        int cardType = shuffledDeck.get(index)/4;
        String description = "";

        switch(cardType){
            case 0: description = "Ace = Waterfall\n" +
                    "\n" +
                    "The person who draws this card starts drinking his or her drink. Everybody starts at the same time and cannot stop drinking until the person to their right stops, starting with the person who drew the card. \n";
                break;
            case 1: description = "Two = You\n " +
                    "\n" +
                    "Pick someone to drink\n"
                    ;
                break;
            case 2: description = "Three = Me\n" +
                    "\n" +
                    "Take a drink yourself\n";
                break;
            case 3: description = "Four = Ladies\n" +
                    "\n" +
                    "All the girls drink\n";
                break;
            case 4: description = "Five = Drive\n" +
                    "\n" +
                    "Pass the wheel to the right or left while saying “vroom.” Receiver of wheel can continue in the same direction saying “vroom” or switch the direction and say “skrrt.” First person to mess up drinks.\n";
                break;
            case 5: description = "Six = Gents\n" +
                    "\n" +
                    "All the guys drink\n";
                break;
            case 6: description = "Seven = Heaven\n" +
                    "\n" +
                    "Last person to point to the sky drinks\n\n";
                break;
            case 7: description = "Eight = Mate\n" +
                    "\n" +
                    "Pick a partner. Every time you drink, he or she drinks and vice versa.\n";
                break;
            case 8: description = "Nine = Rhyme\n" +
                    "\n" +
                    "Say a word that the rest of the people have to rhyme with. Go around one by one clockwise. First person to repeat, say a word that doesn’t rhyme, or say a fake word drinks.\n";
                break;
            case 9: description = "Ten = Categories\n" +
                    "\n" +
                    "Say a category. Everyone has to say something falling in that category. Go around one by one clockwise. First person to mess up drinks. \n";
                break;
            case 10: description = "Jack = Thumb\n" +
                    "\n" +
                    "By picking this card, you have the ability to put your thumb on the table at any point until the next Jack is drawn. Once the thumb is on the table, the last person to put theirs on drinks. \n";
                break;
            case 11: description = "Queen = Question Master\n" +
                    "\n" +
                    "Anybody who answers a question you ask has to drink. This goes away when the Queen is drawn. \n";
                break;
            case 12: description = "King = Rule Maker\n" +
                    "\n" +
                    "Make a rule that everybody has to follow either prior to picking a card or prior to drinking. Those who do not follow this rule must drink. The rule continues to apply until the next King is drawn. (Also pour ¼ of your drink into the center cup)\n";
                    if(kingCount == 4){
                        description = "This is the last king. Drink the kings cup!";
                    }
                break;
            default: description = "error";
                break;

        }

        img.setText(description);


    }

    public void nextButtonClicked(View view) {

        index++;
        if(index > 51){
            gameOver();
        }else {
            Button img = (Button) findViewById(R.id.cardImage);
            img.setBackgroundResource(deck[shuffledDeck.get(index)]);
            Button next = (Button) findViewById(R.id.nextButton);
            if (51-index!=1){
                next.setText("Next: " + (51 - index) + " cards left");
            }else{
                next.setText("Next: " + "1 card left");
            }
            img.setText("");
            if(shuffledDeck.get(index)/4 == 12) kingCount++;
        }
    }

    public void gameOver(){
        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }

    public int[] createDeck(){
        int[] deck = new int[52];
        deck[0] = R.drawable.ace_of_clubs;
        deck[1] = R.drawable.ace_of_diamonds;
        deck[2] = R.drawable.ace_of_hearts;
        deck[3] = R.drawable.ace_of_spades;
        deck[4] = R.drawable.two_of_clubs;
        deck[5] = R.drawable.two_of_diamonds;
        deck[6] = R.drawable.two_of_hearts;
        deck[7] = R.drawable.two_of_spades;
        deck[8] = R.drawable.three_of_clubs;
        deck[9] = R.drawable.three_of_diamonds;
        deck[10] = R.drawable.three_of_hearts;
        deck[11] = R.drawable.three_of_spades;
        deck[12] = R.drawable.four_of_clubs;
        deck[13] = R.drawable.four_of_diamonds;
        deck[14] = R.drawable.four_of_hearts;
        deck[15] = R.drawable.four_of_spades;
        deck[16] = R.drawable.five_of_clubs;
        deck[17] = R.drawable.five_of_diamonds;
        deck[18] = R.drawable.five_of_hearts;
        deck[19] = R.drawable.five_of_spades;
        deck[20] = R.drawable.six_of_clubs;
        deck[21] = R.drawable.six_of_diamonds;
        deck[22] = R.drawable.six_of_hearts;
        deck[23] = R.drawable.six_of_spades;
        deck[24] = R.drawable.seven_of_clubs;
        deck[25] = R.drawable.seven_of_diamonds;
        deck[26] = R.drawable.seven_of_hearts;
        deck[27] = R.drawable.seven_of_spades;
        deck[28] = R.drawable.eight_of_clubs;
        deck[29] = R.drawable.eight_of_diamonds;
        deck[30] = R.drawable.eight_of_hearts;
        deck[31] = R.drawable.eight_of_spades;
        deck[32] = R.drawable.nine_of_clubs;
        deck[33] = R.drawable.nine_of_diamonds;
        deck[34] = R.drawable.nine_of_hearts;
        deck[35] = R.drawable.nine_of_spades;
        deck[36] = R.drawable.ten_of_clubs;
        deck[37] = R.drawable.ten_of_diamonds;
        deck[38] = R.drawable.ten_of_hearts;
        deck[39] = R.drawable.ten_of_spades;
        deck[40] = R.drawable.jack_of_clubs;
        deck[41] = R.drawable.jack_of_diamonds;
        deck[42] = R.drawable.jack_of_hearts;
        deck[43] = R.drawable.jack_of_spades;
        deck[44] = R.drawable.queen_of_clubs;
        deck[45] = R.drawable.queen_of_diamonds;
        deck[46] = R.drawable.queen_of_hearts;
        deck[47] = R.drawable.queen_of_spades;
        deck[48] = R.drawable.king_of_clubs;
        deck[49] = R.drawable.king_of_diamonds;
        deck[50] = R.drawable.king_of_hearts;
        deck[51] = R.drawable.king_of_spades;
        return deck;
    }
}
