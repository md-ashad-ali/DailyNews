package com.example.worldnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String,String>hashMap;
    ArrayList< HashMap<String,String> > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);


        mathodCreate();

        MyList myList = new MyList();
        listView.setAdapter(myList);

    }

    //==================================================================
    //private class
    //==================================================================

    private class MyList extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item,listView,false);

            ImageView item_images = myView.findViewById(R.id.item_images);
            TextView item_catagori = myView.findViewById(R.id.item_catagori);
            TextView item_title = myView.findViewById(R.id.item_title);
            TextView item_des = myView.findViewById(R.id.item_des);
            LinearLayout itemLayout = myView.findViewById(R.id.itemLayout);


            HashMap<String,String> hashMap1 = arrayList.get(position);
            String cat = hashMap1.get("cat");
            String imagelink = hashMap1.get("imagelink");
            String title = hashMap1.get("title");
            String des = hashMap1.get("des");

            Picasso.get()
                    .load(imagelink)
                    .into(item_images);

            item_catagori.setText(cat);
            item_title.setText(title);
            item_des.setText(des);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            item_catagori.setBackgroundColor(color);

            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NewsDetels.TITLE = title;
                    NewsDetels.DESCRIPTION = des;
                    Bitmap bitmap = ((BitmapDrawable) item_images.getDrawable()).getBitmap();
                    NewsDetels.MYBITMAP = bitmap;

                startActivity(new Intent(MainActivity.this,NewsDetels.class));


                }
            });

            return myView;
        }
    }

    //==================================================================
    //private class
    //==================================================================



    //==================================================================
    //Mathod int Arraylist or hashmap
    //==================================================================

    private  void mathodCreate()
    {
        hashMap = new HashMap<>();
        hashMap.put("cat","AI Technology");
        hashMap.put("imagelink","https://content.fortune.com/wp-content/uploads/2023/05/Recommends_ChatGPT_made_money_decisions.jpg?w=1024&q=75");
        hashMap.put("title","I pitted ChatGPT against a real financial advisor to help me save for retirement—and the winner is clear");
        hashMap.put("des","ChatGPT is changing the way people live and work. \n\n" +
                "From teachers to cybercriminals, it seems everyone is jumping on the artificial intelligence (AI) bandwagon. This is only to be expected when it can answer questions faster than any human and save you the trouble of scouring countless Google search results to find what you’re after. Plus, it’s kind of fun to talk to sometimes.\n\nOnce upon a time, I worked for Fidelity Investments. Seeing clients struggle to save enough money for retirement showed me just how important it is to start planning for your golden years as soon as possible. Unfortunately, I know many people don’t have access to the financial guidance they need or deserve." +
                "While my past experiences with ChatGPT have been informative and fun, I wanted to te our relationship to the next level. Could ChatGPT help me plan for retirement too?\n\n ChatGPT could change this by giving people key retirement advice in an accessible and nonintimidating way. Imagine if you could get every financial question answered for free, all from the comfort of your home.\n\nFor my experiment, I pitted ChatGPT against a real financial advisor, working withThomas Kopelman, a financial planner and cofounder of AllStreetWealth.com and head of community at Wealth.com. I asked Kopelman and ChatGPT the same questions to see how they would compare.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Actor");
        hashMap.put("imagelink","https://s.yimg.com/ny/api/res/1.2/44RzcAAC05XmCmk89MmeGg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyNDI7aD0xNzI1O2NmPXdlYnA-/https://media.zenfs.com/en/us_magazine_896/cb994cbb36b212112db2e5b249b9b377");
        hashMap.put("title","Pamela Anderson, 56, Shows Off Her Freckles In A Glowy No-Makeup Pic");
        hashMap.put("des", "Pamela Anderson regularly rocked pin-up style makeup in the ‘90s, but she’s taken on a more fresh-faced look lately that’s kind of everything\n\n" +
                "The 56-year-old just casually dropped a makeup-free shot on Instagram, and she’s literally glowing. \n\n" +
                "The pic features Pamela clutching a flower while grinning broadly. Her freckles are clearly showing and her skin looks so fresh and clear\n\nGaga, 37 — whose real name is Stefani Germanotta — got candid about her therapeutic self-care routine. “It has been a healing practice for me since I was really young,” she told E! News in a Monday, August 21, interview. “I was incredibly insecure when I was a teenager, and when I graduated high school and went off on my own, I discovered that makeup had the power to transform who I was.\n\nIn Gaga’s eyes, her beauty routine is “an extension of my skincare from the morning,” and “an extra boost of confidence.” She explained, “I feel I'm able to brave whatever is coming my way because I've really taken time for myself.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Forbes");
        hashMap.put("imagelink","https://imageio.forbes.com/specials-images/imageserve/64e90c9ef532dda9283b0617/A-Neptune-test-launch-in-2019-/0x0.jpg?format=jpg&crop=1070,602,x0,y75,safe&width=960");
        hashMap.put("title"," To Blow Up Russia’s S-400 Battery  In Crimea, Ukraine Tweaked Its Cruiser-Sinking Neptune Missile");
        hashMap.put("des", "The Ukrainian navy reportedly used some of its Neptune anti-ship missiles in the missiles’ secondary land-attack mode to blow up a Russian air force S-400 air-defense battery in western Crimea on Wednesday.\n\n" +
                "\n" +
                "That the one-ton Neptune can strike targets on the ground should come as no surprise. Ukraine’s Luch Design Bureau modeled the Neptune on the Russian Kh-35, itself an answer to the American Harpoon anti-ship missile, which also has a land-attack mode.\n\n" +
                "\n" +
                "The S-400, the Podlet radar and other weapons on the Crimean cape—including a battery of Bastion anti-ship missiles—topped the list of prospective targets as Ukraine expanded its deep-strike capability this year.\n\nA radar seeker alone is enough for striking ships, as a ship reflects a clear radar signature relative to the flat water around it. Ground targets, by contrast, are surrounded by the clutter of buildings, trees and uneven terrain. But juice a radar-guided missile with GPS, and you might get enough discrimination to steer the munition through the clutter.\n\nLuch in its wisdom fitted the Neptune with GPS from the start. But the design bureau recently made additional tweaks to the missile’s seeker to optimize its land-attack mode, a Ukrainian official told The War Zone this spring. “Once we get that, the Neptunes can hit targets [225 miles] away,” the official said. “We are pretty close.” ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Reuters");
        hashMap.put("imagelink","https://www.ft.com/__origami/service/image/v2/images/raw/https://d1e00ek4ebabms.cloudfront.net/production/1d136ce7-3ed2-4a9b-9da2-1a512115005e.jpg?source=next&fit=scale-down&quality=highest&width=720&dpr=1");
        hashMap.put("title","Xi Jinping dominates Brics summit as leaders endorse Beijing-led expansion");
        hashMap.put("des","Please use the sharing tools found via the share button at the top or side of articles. Copying articles to share with others is a breach of FT.com T&Cs and Copyright Policy. Email licensing@ft.com to buy additional rights. Subscribers may share up to 10 or 20 articles per month using the gift article service. More information can be found here. \n\n" +
                "https://www.ft.com/content/e2b79e25-3f60-4b26-8727-ec4b0a94ae97\n" +
                "\n" +
                "The Chinese president was given special treatment from the minute he arrived ahead of the other leaders for a state visit that saw him inducted into the ‘Order of South Africa’, a recently created honour.\n\n\n" +
                "\tPlease use the sharing tools found via the share button at the top or side of articles. Copying articles to share with others is a breach of FT.com T&Cs and Copyright Policy. Email licensing@ft.com to buy additional rights. Subscribers may share up to 10 or 20 articles per month using the gift article service. More information can be found at https://www.ft.com/tour.\n" +
                "\thttps://www.ft.com/content/e2b79e25-3f60-4b26-8727-ec4b0a94ae97\n" +
                "\n" +
                "\t“The people of South Africa salute you, President Xi Jinping,” Ramaphosa said after he met Xi at the airport, an honour none of the other leaders were given. Even India’s Narendra Modi, leader of the second biggest Brics economy, was greeted by Ramaphosa’s\n\n\n" +
                "\tPlease use the sharing tools found via the share button at the top or side of articles. Copying articles to share with others is a breach of FT.com T&Cs and Copyright Policy. Email licensing@ft.com to buy additional rights. Subscribers may share up to 10 or 20 articles per month using the gift article service. More information can be found at https://www.ft.com/tour.\n" +
                "\thttps://www.ft.com/content/e2b79e25-3f60-4b26-8727-ec4b0a94ae97\n" +
                "\n" +
                "\tXi’s importance can also be seen in the anxiety created when he failed to appear for his first big address of the summit to businesspeople from across the Brics bloc. No explanation was given and he showed up later in the evening for a leaders’ dinner, but it was a low-point of a carefully choreographed event.\n\nThe Brics going from five to 11 countries “meets the expectations of the international community, and serves the common interests of emerging markets and developing countries”, Xi said.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Business");
        hashMap.put("imagelink","https://a57.foxnews.com/static.foxbusiness.com/foxbusiness.com/content/uploads/2021/12/931/523/Chicago-Retail-Crime.jpg?ve=1&tl=1");
        hashMap.put("title","Nordstrom reports 'historical highs' for theft-incurred losses");
        hashMap.put("des","In the retail industry, shrink typically means theft and other types of inventory losses. \n\nThe Seattle-based company has \"done a lot of things\" and is \"looking at everything\" for store safety and security, in addition to addressing losses from theft, the CEO said. \n" +
                "\n" +
                "\"There’s things within our control that we can invest in, but also involves partnering with local jurisdictions, law enforcement,\" Nordstrom continued. \"I think the legislation is part of the mix, too, here that the whole industry needs to come to some of the better solutions on.\n\nRoughly two weeks ago, the Nordstrom located at the Topanga Mall had a large amount of products stolen by a \"mob of criminals,\" according to a social media post from the Los Angeles Police Department. The incident and the state of the store after it happened were captured on video, Fox News Digital reported. ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Technology");
        hashMap.put("imagelink","https://static1.anpoimages.com/wordpress/wp-content/uploads/2023/08/iphone-14-pro-max-render-01.png?q=50&fit=contain&w=480&h=480&dpr=1.5");
        hashMap.put("title","Samsung Galaxy Z Fold 5 vs. Apple iPhone 14 Pro Max: Is the folding screen worth an extra $700?");
        hashMap.put("des","The Samsung Galaxy Z Fold 5 is one of the best Android phones around, as long as you're in search of a foldable device with two displays and a big price tag. The Apple iPhone 14 Pro Max, on the other hand, is the biggest and most powerful iPhone out there. It doesn't fold, but it does have a gorgeous 6.7-inch display and a price that's about $700 less than the Z Fold 5 to start.\n\nAside from price and features, these two phones run on different systems and performance hardware, with a big difference in form factor. Let's drill down into the details to compare the similarities and contrasts to ensure you get the best phone possible\n\nThe Galaxy Z Fold 5 is considered one of the best foldable phones on the market today, and with that distinction comes an elevated price. Models with 256GB of storage start at about $1,800, climbing to $1,920 for 512GB and $2,160 for 1TB. You can reliably find the Z Fold 5 at Samsung's official website, as well as at third-party retailers like Amazon and Best Buy.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Sports");
        hashMap.put("imagelink","https://cdn.theathletic.com/cdn-cgi/image/width=770,format=auto,quality=75/https://cdn.theathletic.com/app/uploads/2023/08/25200112/GettyImages-1612530702-scaled-e1693008095350-1024x682.jpg");
        hashMap.put("title","Trey Lance traded from 49ers to Cowboys: Grading the deal from both sides");
        hashMap.put("des","The 2021 first-round pick would have been the Niners’ third-string quarterback, which would have further complicated his standing with the organization that traded three first-round picks and a third-rounder to draft him at No. 3. The biggest knock on Lance coming out of North Dakota State was his lack of overall experience, and he never got a chance to overcome that issue due to injuries in each of his first two NFL seasons.\n" +
                "\n\nThe Cowboys, of course, are also set with Dak Prescott as their starter, but there are economics at play here. Prescott’s salary-cap hit balloons to $59.455 million in 2024, which is also the final year of his deal.\n" +
                "\n\n Lance, who hasn’t played a full season since 2019, wouldn’t have gotten enough practice reps as the 49ers’ third-string quarterback. Barring injuries to starter Brock Purdy or Darnold, it would have been another washed-out year for Lance in San Francisco. Since Purdy, also 23, is in his second season, the clock was already ticking on Lance’s time with the organization.\n" +
                "\n");
        arrayList.add(hashMap);


    }


    //==================================================================
    //Mathod int Arraylist or hashmap
    //==================================================================


}