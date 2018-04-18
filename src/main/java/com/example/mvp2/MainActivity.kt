package com.example.mvp2

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton

//import for barChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

//cool import for hide findViewById
import kotlinx.android.synthetic.main.fragment.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, IView {

    //buttons
    var toolbar_button: ImageButton? = null
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initialize all views
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val navigationView = findViewById(R.id.nav_view) as NavigationView
        //toolbar_button = toolbar.findViewById(R.id.toolbar_button) as ImageButton
        //toolbar_button!!.setOnClickListener(this)
        button_back.setOnClickListener(this)
        button_forward.setOnClickListener(this)
        //initialize Presenter
        presenter = Presenter(this)

        //customize view
        this.setTitle("")
        setSupportActionBar(toolbar)
        customizeToolbar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClick(v: View?) {
        when (v!!.id){
            button_back.id -> presenter?.onBackButtonClick()
            button_forward.id -> presenter?.onNextButtonClick()
        }
    }

    override fun setTable(data: IntArray) {
        // set the data and list of lables into chart<br />
        val entries:ArrayList<BarEntry> = ArrayList<BarEntry>()
        for (i in data.indices) {
            entries.add(BarEntry(i.toFloat(), data[i].toFloat()))
        }
        val dataset = BarDataSet(entries, "BarDataSet")
        dataset.color = Color.parseColor("#FF8000")
        val barData = BarData(dataset)
        barChart?.setData(barData)
        barChart?.invalidate()
    }

    override fun setAveragePrice(average: Int) {
        averagePriceView?.setText("" + average + " c/kWh")
    }

    override fun setCurrentPrice(current: Int) {
        currentPriceView?.setText("" + current + " c/kWh");
    }

    override fun setDate(date: String) {
        dateView.setText(date)
    }

    private fun customizeToolbar(toolbar: Toolbar) {
        toolbar.navigationIcon = null
        //toolbar.setTitle("Title");
        //toolbar.setSubtitle("Sub");
        //toolbar.setLogo(R.drawable.logo);

    }

}
