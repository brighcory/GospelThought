package com.merlin.bright.cory.gospelthought;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_REMINDER_NIGHT = 11;
    private Context context = this;
    public static String[] quote = {
            "God cares a lot more about who we are, and who we are becoming, than about who we once were.—Elder Dale G. Renlund",
            "[Easter] is the day that changed everything.—President Dieter F. Uchtdorf",
            "Families are the Lord’s workshop on earth to help us learn and live the gospel.—Sister Cheryl A. Esplin",
            "We are on His errand. Let us learn of Him. Let us follow in His footsteps. Let us live by His precepts.—President Thomas S. Monson",
            "All of us need the Savior’s Atonement to heal us. All of us are lost and need to be found.—Elder Brent H. Nielson",
            "The power to speak and act in God’s name requires revelation.—President Henry B. Eyring",
            "No other work transcends that of righteous, intentional parenting!—President Russell M. Nelson",
            "How we live our religion is far more important than what we may say about our religion.—Elder Robert D. Hales"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mImageView = findViewById(R.id.imageView);
        TextView mTextView = findViewById(R.id.textView);

        int[] imageResources = {R.drawable.christ_healing_the_blind_man_39555_mobile,
                R.drawable.christ_rich_young_ruler_hofmann_1020802_mobile,
                R.drawable.jesus_blessing_the_children_39562_mobile,
                R.drawable.jesus_calms_the_storm_39557_mobile,
                R.drawable.lord_prayer_art_lds_451512_mobile,
                R.drawable.lost_lamb_art_lds_425852_mobile,
                R.drawable.mary_and_the_resurrected_christ_39605_mobile,
                R.drawable.pool_of_bethesda_carl_bloch_83121_mobile,
                R.drawable.jesus_washing_apostles_feet_39588_mobile,
                R.drawable.young_jesus_comforting_his_mother_82711_mobile,
                R.drawable.jesus_at_the_door_39617_mobile};

        Random r = new Random();
        int index = r.nextInt(imageResources.length);
        mImageView.setImageResource(imageResources[index]);

        mTextView.setText(getQuote());

        Intent notifyIntent = new Intent(this, GospelThoughtReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (context, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 5 * 1000,
                1000 * 60 * 60 * 24,
                pendingIntent);
    }

    public static String getQuote() {
        Random r = new Random();
        int quoteIndex = r.nextInt(quote.length);
        return quote[quoteIndex];
    }
}
