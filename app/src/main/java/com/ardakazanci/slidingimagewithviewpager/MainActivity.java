package com.ardakazanci.slidingimagewithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	ViewPager viewPager;
	ViewPagerAdapter viewPagerAdapter;

	String[] images = {

			"http://tr.web.img4.acsta.net/r_640_360/newsv7/19/05/20/16/43/1308138.jpg",
			"https://specials-images.forbesimg.com/imageserve/5d4093ef95e0230008f70a3d/960x0.jpg?fit=scale",
			"https://iasbh.tmgrup.com.tr/e839d2/752/395/0/0/960/503?u=https://isbh.tmgrup.com.tr/sbh/2019/05/30/john-wick-3-filminin-konusu-ne-john-wick-3-oyunculari-1559204555884.jpg",
			"https://specials-images.forbesimg.com/imageserve/5d49680537f1f90008ec638c/960x0.jpg?fit=scale"

	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = findViewById(R.id.viewPager);
		viewPagerAdapter = new ViewPagerAdapter(MainActivity.this,images);
		viewPager.setAdapter(viewPagerAdapter);


	}
}
