package com.example.ikemura.android_animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ImageView imageView = (ImageView) findViewById(R.id.imageView);
				runAnimation(imageView);
				// changeImage(imageView);
				// runAnimation2(imageView);
			}
		});
	}

	private void runAnimation(ImageView imageView) {

		// rotationプロパティを0fから360fに変化させます
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "rotationY", 0f, 180f);

		// 3秒かけて実行させます
		objectAnimator.setDuration(100);

		objectAnimator.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animator) {

			}

			@Override
			public void onAnimationEnd(Animator animator) {
				ImageView imageView = (ImageView) findViewById(R.id.imageView);
				changeImage(imageView);
				// runAnimation2(imageView);
			}

			@Override
			public void onAnimationCancel(Animator animator) {

			}

			@Override
			public void onAnimationRepeat(Animator animator) {

			}
		});
		// アニメーションを開始します
		objectAnimator.start();
	}

	private void changeImage(ImageView imageView) {
		imageView.setImageResource(R.drawable.sozai2);
	}

	private void runAnimation2(ImageView imageView) {

		// rotationプロパティを0fから360fに変化させます
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "rotationY", 0f, 180f);

		// 3秒かけて実行させます
		objectAnimator.setDuration(100);

		// アニメーションを開始します
		objectAnimator.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
