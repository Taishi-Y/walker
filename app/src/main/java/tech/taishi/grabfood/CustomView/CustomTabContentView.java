package tech.taishi.grabfood.CustomView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import tech.taishi.grabfood.R;

/**
 * Created by yamasakitaishi on 2016/10/18.
 */

public class CustomTabContentView extends FrameLayout {
	Context context;


	public CustomTabContentView(Context context) {
		super(context);
	}

	public CustomTabContentView(Context context,  int icon) {
		this(context);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View childview1 = inflater.inflate(R.layout.tabwidget_search, null);

		ImageView iv1 = (ImageView) childview1.findViewById(R.id.imageview);
		iv1.setImageResource(icon);
		addView(childview1);
	}
}
