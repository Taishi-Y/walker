package tech.taishi.grabfood.Animation;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;



/**
 * Created by yamasakitaishi on 2016/10/17.
 */



public class FloatingAnimationListener implements Animation.AnimationListener {

	ImageView imageView;
	public FloatingAnimationListener(ImageView imageView) {
		this.imageView = imageView;

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		imageView.clearAnimation();
		ViewGroup.LayoutParams lp = imageView.getLayoutParams();
//				new LayoutParams(imageView.getWidth(), imageView.getHeight());
//		lp.
		ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) lp;
		mlp.setMargins(50, 100, 0, 0);
//		lp.setMargins(50, 100, 0, 0);
		imageView.setLayoutParams(lp);
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

	@Override
	public void onAnimationStart(Animation animation) {
	}

}