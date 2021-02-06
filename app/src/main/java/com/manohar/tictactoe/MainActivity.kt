package com.manohar.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bclicks(view: View)
    {

        val isselected= view as Button
        var cellid:Int= 0
        when(isselected.id)
        {
            R.id.view1 -> cellid = 1
            R.id.view2 -> cellid = 2
            R.id.view3 -> cellid = 3
            R.id.view4 -> cellid = 4
            R.id.view5 -> cellid = 5
            R.id.view6 -> cellid = 6
            R.id.view7 -> cellid = 7
            R.id.view8 -> cellid = 8
            R.id.view9 -> cellid = 9

        }

        //.makeText(this, cellid.toString(), Toast.LENGTH_SHORT).show()
        playgame(cellid, isselected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activeplayer= 1


    fun playgame(cellid:Int, isSelected:Button)
    {
        if (activeplayer == 1)
        {
            isSelected.setText("X")
            isSelected.setBackgroundColor(applicationContext.resources.getColor(R.color.teal_700))
            activeplayer = 2
            player1.add(cellid)
            autoPlay()
        }
        else
        {
            isSelected.setText("O")
            isSelected.setBackgroundColor(applicationContext.resources.getColor(R.color.red))
            activeplayer = 1
            player2.add(cellid)
        }
        isSelected.isEnabled = false
        checkWinner()

    }

    fun checkWinner()
    {
        var winner:Int = -1

        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) )
        {
            winner =1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3) )
        {
            winner =2
        }

        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6) )
        {
            winner =1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6) )
        {
            winner =2
        }

        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9) )
        {
            winner =1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9) )
        {
            winner =2
        }

        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7) )
        {
            winner =1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7) )
        {
            winner =2
        }

        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8) )
        {
            winner =1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(6) )
        {
            winner =2
        }

        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9) )
        {
            winner =1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9) )
        {
            winner =2
        }

        //cross1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9) )
        {
            winner =1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9) )
        {
            winner =2
        }

        //cross2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7) )
        {
            winner =1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7) )
        {
            winner =2
        }


        if (winner!=-1) //we have a winner
        {
            if (winner==1)
            {
                Toast.makeText(this, "You won the game", Toast.LENGTH_SHORT).show()
                disableButtons()

            }
            else if (winner == 2)
            {
                Toast.makeText(this, "CPU won the game", Toast.LENGTH_SHORT).show()
                disableButtons()
            }
            else
            {
                Toast.makeText(this, "It was a tie !", Toast.LENGTH_SHORT).show()
                disableButtons()
            }
        }

    }

    fun autoPlay()
    {

        var EmptycellIds = ArrayList<Int>()
        for (cellid in 1..9)
        {
            if (!(player1.contains(cellid) || player2.contains(cellid)))
            {
                EmptycellIds.add(cellid)
            }
        }

        Toast.makeText(this, EmptycellIds.size.toString(), Toast.LENGTH_SHORT).show()
        if (EmptycellIds.size-1<1) // Do not allow to play if only one place is vacant
        {
            disableButtons()
            Toast.makeText(this, "Tie", Toast.LENGTH_LONG).show()
        }
        else
        {
            var r = Random
            var indexRandom = r.nextInt(EmptycellIds.size-0)+0
            var cellid = EmptycellIds.get(indexRandom)

            var isSelected: Button?
            when(cellid)
            {
                1-> isSelected = findViewById(R.id.view1)
                2-> isSelected = findViewById(R.id.view2)
                3-> isSelected = findViewById(R.id.view3)
                4-> isSelected = findViewById(R.id.view4)
                5-> isSelected = findViewById(R.id.view5)
                6-> isSelected = findViewById(R.id.view6)
                7-> isSelected = findViewById(R.id.view7)
                8-> isSelected = findViewById(R.id.view8)
                9-> isSelected = findViewById(R.id.view9)
                else -> isSelected = findViewById(R.id.view1)
            }

            playgame(cellid, isSelected)
        }



    }

    fun disableButtons()
    {
        var button1: Button = findViewById(R.id.view1)
        button1.isClickable = false

        var button2: Button = findViewById(R.id.view2)
        button2.isClickable = false

        var button3: Button = findViewById(R.id.view3)
        button3.isClickable = false

        var button4: Button = findViewById(R.id.view4)
        button4.isClickable = false

        var button5: Button = findViewById(R.id.view5)
        button5.isClickable = false

        var button6: Button = findViewById(R.id.view6)
        button6.isClickable = false

        var button7: Button = findViewById(R.id.view7)
        button7.isClickable = false

        var button8: Button = findViewById(R.id.view8)
        button8.isClickable = false

        var button9: Button = findViewById(R.id.view9)
        button9.isClickable = false



    }

    fun restart(view: View)
    {
        val intent1 = Intent(this,  MainActivity::class.java)
        finish()
        startActivity(intent1)

    }




}