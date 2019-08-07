package com.ardakazanci.slidingimagewithviewpager;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

public class ViewPagerAdapter extends PagerAdapter {

	/**
	 * Gerekli Field
	 */
	Activity activity;
	String[] images;
	LayoutInflater layoutInflater;

	/**
	 *
	 * @param activity : Context
	 * @param images : İmages Array Listesi
	 */
	public ViewPagerAdapter(Activity activity, String[] images) {
		this.activity = activity;
		this.images = images;

	}


	/**
	 *
	 * @return Toplam array uzunluğu
	 */
	@Override
	public int getCount() {
		return images.length;
	}

	/**
	 *
	 * @param view : Görünümün bulunduğu obje.
	 * @param object : Görünümde gösterilecek obje.
	 * @return
	 *
	 * Sayfa görünümünün herhangi bir nesne ile ilişkili olup olmadığını belirler.
	 *
	 */
	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}


	/**
	 *
	 * Fotoğrafların ilgili view görünümlerinde gösterilmesi sağlanır.
	 * İlgili sayfa pozisyonu için görünüm oluşturulur.
	 *
	 * @param container : Görünüm grubu.
	 * @param position : Hangi sırada gösterilecek.
	 * @return : Görünüm objesi döndürülecek.
	 */

	@Override
	public Object instantiateItem( ViewGroup container, int position) {

		layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = layoutInflater.inflate(R.layout.viewpager_item, container, false);

		ImageView imageView;
		imageView = view.findViewById(R.id.imageView);
		// Ekran boyutuna göre tüm fotoğrafların doğru oradan gösterilemsi için gerekli.
		DisplayMetrics dis = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dis);
		int height = dis.heightPixels;
		int width = dis.widthPixels;

		imageView.setMinimumHeight(height);
		imageView.setMinimumWidth(width);

		try {

			Picasso.get().load(images[position])
					.placeholder(R.mipmap.ic_launcher)
					.error(R.mipmap.ic_launcher_round)
					.into(imageView);

		} catch (Exception ex) {

			ex.printStackTrace();

		}


		container.addView(view);
		return view;


	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		((ViewPager) container).removeView((View) object);
	}
}
