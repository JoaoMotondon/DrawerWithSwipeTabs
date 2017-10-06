package com.motondon.drawerwithswipetabs.view.fragment.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.motondon.drawerwithswipetabs.R;
import com.motondon.drawerwithswipetabs.view.adapter.RoutersNewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedsFragment extends Fragment {

    @BindView(R.id.rv_news_list) RecyclerView recyclerView;
    private List<News> newsList = new ArrayList<>();

    public class News {
        public String imageUrl;
        public String newsTitle;
        public String newsDetails;
        public String newsUrl;
        
        public News(String imageUrl, String newsTitle, String newsDetails, String newsUrl) {
            this.imageUrl = imageUrl;
            this.newsTitle = newsTitle;
            this.newsDetails = newsDetails;
            this.newsUrl = newsUrl;
        }
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_feeds, container, false);

        ButterKnife.bind(this, root);

        newsList.add(new News("http://s4.reutersmedia.net/resources/r/?m=02&d=20170102&t=2&i=1167366477&w=300&fh=&fw=&ll=&pl=&sq=&r=2017-01-02T194508Z_25292_RC1F7494CBA0_RTRMADP_0_EUROPE-MIGRANTS", "Rescue in the Mediterranean", "112 migrants on a raft, including two pregnant women and five children, are rescued in the Mediterranean Sea off the coast of Libya.", "http://www.reuters.com/news/picture/rescue-in-the-mediterranean?articleId=USRTX2X93I"));
        newsList.add(new News("http://s3.reutersmedia.net/resources/r/?m=02&d=20170102&t=2&i=1167359188&w=300&fh=&fw=&ll=&pl=&sq=&r=2017-01-02T174508Z_25289_LR1ED120RQQ48_RTRMADP_0_TURKEY-ATTACK", "Turkey mourns after Istanbul nightclub attack", "Turkey mourns after a New Year's Day mass shooting at a packed Istanbul nightclub killed 39 people.", "http://www.reuters.com/news/picture/turkey-mourns-after-istanbul-nightclub-a?articleId=USRTX2X9S2"));
        newsList.add(new News("http://s4.reutersmedia.net/resources/r/?m=02&d=20170102&t=2&i=1167354406&w=300&fh=&fw=&ll=&pl=&sq=&r=2017-01-02T163006Z_25288_RC1485DCE290_RTRMADP_0_MIDEAST-CRISIS-IRAQ-BLAST", "Islamic State strikes Baghdad", "An Islamic State car bomb killed 24 people in a busy square in Baghdad's sprawling Sadr City district.", "http://www.reuters.com/news/picture/islamic-state-strikes-baghdad?articleId=USRTX2X98E"));
        newsList.add(new News("http://s1.reutersmedia.net/resources/r/?m=02&d=20170102&t=2&i=1167351136&w=300&fh=&fw=&ll=&pl=&sq=&r=2017-01-02T154006Z_25286_RC16BFE9BE20_RTRMADP_0_NEW-YEAR-SLOVENIA", "New Year plunge", "Revelers take a dip to mark the new year.", "http://www.reuters.com/news/picture/new-year-plunge?articleId=USRTX2X8U7"));
        newsList.add(new News("http://s1.reutersmedia.net/resources/r/?m=02&d=20170102&t=2&i=1167319927&w=300&fh=&fw=&ll=&pl=&sq=&r=2017-01-02T052135Z_25284_RC1FA3035290_RTRMADP_0_NEW-YEAR-AUSTRALIA", "Ringing in 2017", "Revelers around the world turn out to celebrate New Year's Eve and welcome 2017.", "http://www.reuters.com/news/picture/ringing-in?articleId=USRTX2X34X"));
        newsList.add(new News("http://s4.reutersmedia.net/resources/r/?m=02&d=20170102&t=2&i=1167319650&w=300&fh=&fw=&ll=&pl=&sq=&r=2017-01-02T051507Z_25283_HT1EC7K03DC23_RTRMADP_0_USA-ELECTION-REPUBLICANS", "The year America chose Trump", "A look back at the U.S. presidential election campaign of 2016", "http://www.reuters.com/news/picture/the-year-america-chose-trump?articleId=USRTX2X35V"));
        newsList.add(new News("http://s4.reutersmedia.net/resources/r/?m=02&d=20161230&t=2&i=1167173567&w=300&fh=&fw=&ll=&pl=&sq=&r=2016-12-30T221008Z_25272_S1AETORGYTAA_RTRMADP_0_USA-POLICE-PROTESTS", "Pictures of the year 2016", "Our top photos from the past year.", "http://www.reuters.com/news/picture/pictures-of-the-year?articleId=USRTSTAMS"));
        newsList.add(new News("http://s4.reutersmedia.net/resources/r/?m=02&d=20161230&t=2&i=1167168759&w=300&fh=&fw=&ll=&pl=&sq=&r=2016-12-30T210941Z_25271_S1BEUCNVFHAA_RTRMADP_0_PHILIPPINES-DRUGS", "Duterte wages brutal war on drugs", "Philippine President Rodrigo Duterte's \"war on drugs\" has killed thousands of people since he took office.", "http://www.reuters.com/news/picture/duterte-wages-brutal-war-on-drugs?articleId=USRTX2U0GF"));
        newsList.add(new News("http://s3.reutersmedia.net/resources/r/?m=02&d=20161230&t=2&i=1167164257&w=300&fh=&fw=&ll=&pl=&sq=&r=2016-12-30T202014Z_25268_RC1663A57240_RTRMADP_0_MIDEAST-CRISIS-IRAQ-MOSUL", "Second phase of Mosul offensive begins", "Iraqi security forces begin the second phase of their offensive against Islamic State militants in Mosul, pushing from three directions into eastern districts where the battle has been deadlocked for nearly a month.", "http://www.reuters.com/news/picture/second-phase-of-mosul-offensive-begins?articleId=USRTX2WV70"));
        newsList.add(new News("http://s2.reutersmedia.net/resources/r/?m=02&d=20161230&t=2&i=1167163143&w=300&fh=&fw=&ll=&pl=&sq=&r=2016-12-30T200505Z_25267_S1AETTWLGCAC_RTRMADP_0_NINTENDO-POKEMON-HONGKONG", "Top Google searches of 2016", "What the world searched for this year.", "http://www.reuters.com/news/picture/top-google-searches-of?articleId=USRTX2WYPD"));
        newsList.add(new News("http://s1.reutersmedia.net/resources/r/?m=02&d=20161229&t=2&i=1167063670&w=300&fh=&fw=&ll=&pl=&sq=&r=2016-12-29T204513Z_25263_GF10000225683_RTRMADP_0_RUSSIA-USA", "Obama and Putin over the years ", "Moments between U.S. President Barack Obama and Russian President Vladimir Putin.", "http://www.reuters.com/news/picture/obama-and-putin-over-the-years?articleId=USRTX2WW15"));
        newsList.add(new News("http://s4.reutersmedia.net/resources/r/?m=02&d=20161229&t=2&i=1166989517&w=300&fh=&fw=&ll=&pl=&sq=&r=2016-12-29T032010Z_25256_RC17F87D5740_RTRMADP_0_PEOPLE-REYNOLDS", "Debbie and Carrie together ", "Debbie Reynolds, a leading lady in Hollywood musicals and comedies including \"Singin' in the Rain,\" died just one day after the death of her daughter, actress Carrie Fisher.", "http://www.reuters.com/news/picture/debbie-and-carrie-together?articleId=USRTX2WSNB"));

        RoutersNewsAdapter adapter = new RoutersNewsAdapter(getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setData(newsList);

        return root;
    }
}
