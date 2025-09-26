package com.example.lab_week_06

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this),
            object: CatAdapter.OnClickListener{
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Ragdoll,
                    "Stainless",
                    "Stainless, a mechanical engineer and the leader of Squad 11 of the Londinium Citizens' Self-Salvation Corps. After fighting together with Rhodes Island during the Londinium incident, he signed a long-term cooperation agreement with Rhodes Island and " +
                            "currently participates as an engineer in various operations across Victoria. ",
                    "https://arknights.wiki.gg/images/Stainless_icon.png?460d27"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ScottishFold,
                    "Goldenglow",
                    "Goldenglow, Rhodes Island Logistics Operator. Primary place of work is the Rhodes Island hair salon; under typical circumstances, is not dispatched in Field Operator capacity.\n" +
                            "Uses a specially designed staff, conducting attacks on the enemy via control of \"Driftbeacon\" Arts Units. ",
                    "https://arknights.wiki.gg/images/Goldenglow_icon.png?21f1c6"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.EurasianLynx,
                    "Kal'tsit",
                    "Kal'tsit, one of Rhodes Island's high-level administrative crew, and leader to Rhodes Island's medical projects. Profoundly learned in metallurgy, sociology, Originium Arts, archaeology, history and genealogy, economics, botany, geology, and other fields. In a portion of Rhodes Island operations, provides medical theory assistance and emergency aid apparatus as medical personnel. Simultaneously, active in many projects as a major constituent of Rhodes Island's command system. ",
                    "https://static.wikia.nocookie.net/mrfz/images/a/ac/Kal%27tsit_icon.png/revision/latest?cb=20211106020354"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.BlackPanther,
                    "Schwarz",
                    "Formerly both SP for the Mayor of Siesta and the Bureau Chief of the Urban Public Security Bureau, Schwarz joined Rhodes Island at the same time as Ceylon.\n" +
                            "She has outstanding achievements in covert operations, reconnaissance and anti-reconnaissance, survival, and crossbow usage. She is in charge of protecting the Doctor and is responsible for the training of basic level Rhodes Island operators. ",
                    "https://static.wikia.nocookie.net/mrfz/images/d/d8/Schwarz_icon.png/revision/latest?cb=20190829230800"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Bombay,
                    "Jessica the Liberated",
                    "Jessica Brynley, after leaving Blacksteel's base for personal reasons. She chose to go to the barrenlands and became a sheriff. She now supports Rhodes Island as a partnering operator at the local office. ",
                    "https://static.wikia.nocookie.net/mrfz/images/7/76/Jessica_the_Liberated_icon.png/revision/latest?cb=20230905085317"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.MackerelTabby,
                    "Rosmontis",
                    "Rhodes Island Elite Operator Rosmontis possesses a high aptitude for a rare form of Originium Arts particularly adept at confronting large creatures, destroying hard objectives, immobilizing facilities under emergency, and putting a stop to small-scale skirmishes. She has been shown to possess a solid control of the battlefield and considerable tactical value in assault, positional, and annihilation scenarios. Under Kal'tsit's assignment, she is currently active as a core annihilation specialist.\n" +
                            "All other files pertaining to Rosmontis have been moved to the high clearance database. ",
                    "https://arknights.wiki.gg/images/Rosmontis_icon.png?36520a"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.WhiteTiger,
                    "Mountain",
                    "The son of a top Columbian construction CEO, Mountain and his entire family were put in prison after they were framed by a rival corporation. He enlisted in Rhodes Island upon his escape.\n" +
                            "Mountain possesses a physique naturally fit for combat, and he is currently active as a Guard Operator and on the frontlines of a variety of missions. ",
                    "https://static.wikia.nocookie.net/mrfz/images/1/19/Mountain_icon.png/revision/latest?cb=20201217054507"
                )

            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}