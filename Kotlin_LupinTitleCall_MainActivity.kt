package com.koushi.lupin

import android.content.pm.ActivityInfo
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

	// 実行中フラグ
	var flgPlay = false

	lateinit var sp: SoundPool
	var sid01 = 0
	var sid02 = 0

	@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// 画面横向き設定
		requestedOrientation =
			ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

		// 効果音準備
		sp = SoundPool.Builder()
			.setMaxStreams(2)
			.build()

		sid01 = sp.load(this, R.raw.sound01, 1)
		sid02 = sp.load(this, R.raw.sound02, 1)
	}

	fun doLupin(view: View) {

		// 実行中の判定
		if (flgPlay) return

		flgPlay = true

		val tit = "ルパンは燃えているか・・・・?!"
		var idx = 0

		println("1.${Thread.currentThread().id}：" +
				"${Thread.currentThread().name}")

		val tmr = Timer()
		tmr.schedule(0, 200) {
			println("2.${Thread.currentThread().id}：" +
					"${Thread.currentThread().name}")

			runOnUiThread {
				if (idx < tit.length) {
					//  1文字処理
//					println(tit[idx])
					tvTitle.textSize = 180f
					tvTitle.text = tit[idx].toString()

					// 効果音再生
					sp.play(sid01,
						1f, 1f,
						0, 0, 1f)
				} else {
					// 最後の処理
					tmr.cancel()
//					println(tit)
					tvTitle.textSize = 60f
					tvTitle.text = tit

					// 効果音再生
					sp.play(sid02,
						1f, 1f,
						0, 0, 1f)

					flgPlay = false
				}

//				idx = idx + 1
//				idx += 1
				idx++    // インクリメント
			}
		}


//		var rnb = Runnable {  }
//		rnb = Runnable {
//
//			if (idx < tit.length) {
//				//  1文字処理
//				tvTitle.textSize = 180f
//				tvTitle.text = tit[idx].toString()
//
//				// 効果音再生
//				sp.play(sid01,
//					1f, 1f,
//					0, 0, 1f)
//
//				Handler(Looper.getMainLooper()).postDelayed(rnb, 300)
//			} else {
//				// 最後の処理
//				tvTitle.textSize = 60f
//				tvTitle.text = tit
//
//				// 効果音再生
//				sp.play(sid02,
//					1f, 1f,
//					0, 0, 1f)
//
//				flgPlay = false
//			}
//
//			idx++
//		}
//		Handler(Looper.getMainLooper()).post(rnb)
	}
}