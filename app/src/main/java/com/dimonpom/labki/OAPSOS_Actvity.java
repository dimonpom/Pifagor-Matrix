package com.dimonpom.labki;

import android.app.ActionBar;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class OAPSOS_Actvity extends AppCompatActivity {

    public String zeroB="", fiveB="", twoB="", oneB="", threeB="", fourB="", sixB="", sevenB="", eightB="", nineB="", tenB="", elevenB="", twelveB="";
    public String zeroB1="", fiveB1="", twoB1="", oneB1="", threeB1="", fourB1="", sixB1="", sevenB1="", eightB1="", nineB1="", tenB1="", elevenB1="", twelveB1="";
    public int sum1, sum2, sum3, sum4, sum1d, sum2d, sum3d, sum4d;
    public String Year="", Month="", Day="";
    public boolean isOpened=false,isCanBEOpened=false;
    public Spinner spY,spM, spD;


    private TextView TvZero, TvOne, TvTwo, TvThree, TvFour, TvFive, TvSix, TvSeven, TvEight, TvNine, TvTen, TvEleven, TvTwelve, TvSum1, TvSum2, TvSum3, TvSum4, TvDopRes, TvDopInfo;
    private TextView Pc1, Pc2, Pc3, Pc4, Pc5, Pc6, tvDop;
    private TableRow TrZero;
    private GraphView grapV;
    private int[][] monthCalc = new int[13][31];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oapsos__actvity);

        grapV = findViewById(R.id.graphView);

        spY = findViewById(R.id.sYear);
        spM = findViewById(R.id.sMonth);
        spD = findViewById(R.id.sDay);

        Pc1 = findViewById(R.id.PerPC);
        Pc2 = findViewById(R.id.VtoPC);
        Pc3 = findViewById(R.id.TrePC);
        Pc4 = findViewById(R.id.ChePC);
        Pc5 = findViewById(R.id.PatPC);
        Pc6 = findViewById(R.id.HesPC);

        TvZero = findViewById(R.id.tV_Zero);
        TvOne = findViewById(R.id.tV_One);
        TvTwo = findViewById(R.id.tV_Two);
        TvThree = findViewById(R.id.tV_Three);
        TvFour = findViewById(R.id.tV_Four);
        TvFive = findViewById(R.id.tV_Five);
        TvSix = findViewById(R.id.tV_Six);
        TvSeven = findViewById(R.id.tV_Seven);
        TvEight = findViewById(R.id.tV_Eight);
        TvNine = findViewById(R.id.tV_Nine);
        TvTen = findViewById(R.id.tV_Ten);
        TvEleven = findViewById(R.id.tV_Eleven);
        TvTwelve = findViewById(R.id.tV_Twelve);
        TvSum1 = findViewById(R.id.tV_Sum1);
        TvSum2 = findViewById(R.id.tV_Sum2);
        TvSum3 = findViewById(R.id.tV_Sum3);
        TvSum4 = findViewById(R.id.tV_Sum4);
        TvDopRes = findViewById(R.id.DopTv);
        TrZero = findViewById(R.id.Tr_smth);
        TvDopInfo = findViewById(R.id.Tv_dop);
        tvDop = findViewById(R.id.textView9);
        TvDopRes.setHeight(0);

        ArrayAdapter<?> adapter1 = ArrayAdapter.createFromResource(this, R.array.years,  R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spY.setAdapter(adapter1);
        spY.setSelection(60);

        ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this, R.array.months,  R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spM.setAdapter(adapter2);
        spM.setSelection(8);

        final ArrayAdapter<?> adapterD1 = ArrayAdapter.createFromResource(this, R.array.days31,  R.layout.support_simple_spinner_dropdown_item);
        adapterD1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spD.setAdapter(adapterD1);
        spD.setSelection(2);

        grapV.getViewport().setYAxisBoundsManual(true);
        grapV.getViewport().setMinY(0.5);
        grapV.getViewport().setMaxY(8);

        grapV.getViewport().setXAxisBoundsManual(true);
        grapV.getViewport().setMinX(0.5);
        grapV.getViewport().setMaxX(31);

        grapV.getViewport().setScalable(true);

        TvZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kzeroth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(0));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kfirst);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(1));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Ksecond);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(2));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kthird);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(3));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kfourth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(4));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kfifth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(5));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Ksixth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(6));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kseventh);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(7));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Keighth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(8));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Kninht);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(9));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Ktenth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(10));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Keleventh);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(11));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });
        TvTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCanBEOpened) {
                    TvDopInfo.setText(R.string.Ktwelth);
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(makepoints(12));
                    grapV.removeAllSeries();
                    grapV.addSeries(series1);
                    grapV.setVisibility(View.VISIBLE);
                    tvDop.setVisibility(View.VISIBLE);
                }
            }
        });

        spY.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choose = getResources().getStringArray(R.array.years);
                Year = choose[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Year = "1998";
            }
        });

        spM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choose = getResources().getStringArray(R.array.months);
                Month = choose[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Month = "09";
            }
        });

        spD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choose = getResources().getStringArray(R.array.days31);
                Day = choose[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Day = "03";
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start_menu, menu);
        return true;
    }
    public DataPoint[] makepoints(int id){
        DataPoint[] values = new DataPoint[31];
        for (int j=0; j<31; j++){
            double x = j+1;
            double y = monthCalc[id][j];
            DataPoint v = new DataPoint(x,y);
            values[j]=v;
        }
        return values;
    }

    public void ClearTable(){
        TvZero.setText("-");
        TvOne.setText("-");
        TvTwo.setText("-");
        TvThree.setText("-");
        TvFour.setText("-");
        TvFive.setText("-");
        TvSix.setText("-");
        TvSeven.setText("-");
        TvEight.setText("-");
        TvNine.setText("-");
        TvTen.setText("-");
        TvEleven.setText("-");
        TvTwelve.setText("-");
        TvSum1.setText("");
        TvSum2.setText("");
        TvSum3.setText("");
        TvSum4.setText("");
        Pc1.setText("");
        Pc2.setText("");
        Pc3.setText("");
        Pc4.setText("");
        Pc5.setText("");
        Pc6.setText("");
    }
    public int[] calculationPCH (char[] Y, char[] M, char[] D){
        int Sum=0;
        int[] X = new int[14];

        X[0]= D[0]- '0';
        X[1]= D[1]- '0';
        X[2]= M[0]- '0';
        X[3]= M[1]- '0';
        X[4]= Y[0]- '0';
        X[5]= Y[1]- '0';
        X[6]= Y[2]- '0';
        X[7]= Y[3]- '0';

        for (int i=0; i<8; i++)
            Sum+=X[i];
        X[8]=Sum;
        X[9]=SumOfNum(X[8]);
        X[10]=X[8]-(2*X[0]);
        X[11]=SumOfNum(X[10]);
        X[12]=X[8]+X[10];
        X[13]=X[9]+X[11];

        for(int i=0; i<X.length; i++) {
            Zapoln(X[i], (byte) i);
        }
        for(int i=8; i<X.length; i++){
            ZapolnDop(X[i], (byte) i);
        }
        return X;
    }

    public void calculationForMonth (char[] Y, char[] M){
        String Day1;
        for (int j=0; j<31; j++){
            if(j<9)
                Day1="0"+(j+1);
            else
                Day1=""+(j+1);
            calculationPCH(Y,M,Day1.toCharArray());
            monthCalc[0][j]=zeroB.length();
            monthCalc[1][j]=oneB.length();
            monthCalc[2][j]=twoB.length();
            monthCalc[3][j]=threeB.length();
            monthCalc[4][j]=fourB.length();
            monthCalc[5][j]=fiveB.length();
            monthCalc[6][j]=sixB.length();
            monthCalc[7][j]=sevenB.length();
            monthCalc[8][j]=eightB.length();
            monthCalc[9][j]=nineB.length();
            monthCalc[10][j]=(tenB.length()/2);
            monthCalc[11][j]=(elevenB.length()/2);
            monthCalc[12][j]=(twelveB.length()/2);
            zeroB=""; fiveB=""; twoB=""; oneB=""; threeB=""; fourB=""; sixB=""; sevenB=""; eightB=""; nineB=""; tenB=""; elevenB=""; twelveB="";
            zeroB1=""; fiveB1=""; twoB1=""; oneB1=""; threeB1=""; fourB1=""; sixB1=""; sevenB1=""; eightB1=""; nineB1=""; tenB1=""; elevenB1=""; twelveB1="";
        }
    }

    public void Calculate(MenuItem item) {
        grapV.setVisibility(View.INVISIBLE);
        isCanBEOpened=true;
        ClearTable();
        char [] YearArray = Year.toCharArray();
        char [] MonthArray = Month.toCharArray();
        char [] DayArray = Day.toCharArray();
        int[] mass = new int[14];

        mass = calculationPCH(YearArray, MonthArray, DayArray);
        TvDopRes.setText("1: "+mass[0]+"+"+mass[1]+"+"+mass[2]+"+"+mass[3]+"+"+mass[4]+"+"+mass[5]+"+"+mass[6]+"+"+mass[7]+"="+mass[8]+"\n");
        int c = mass[8]%10;
        int d = mass[8]/10;
        TvDopRes.append("2: "+c+"+"+d+"="+mass[9]+"\n");
        TvDopRes.append("3: "+mass[8]+"-(2*"+mass[0]+")="+mass[10]+"\n");
        c = mass[10]%10;
        d = mass[10]/10;
        TvDopRes.append("4: "+c+"+"+d+"="+mass[11]+"\n");
        TvDopRes.append("5: "+mass[8]+"+"+mass[10]+"="+mass[12]+"\n");
        TvDopRes.append("6: "+mass[9]+"+"+mass[11]+"="+mass[13]+"\n");

        Pc1.setText(String.valueOf(mass[8]));
        Pc2.setText(String.valueOf(mass[9]));
        Pc3.setText(String.valueOf(mass[10]));
        Pc4.setText(String.valueOf(mass[11]));
        Pc5.setText(String.valueOf(mass[12]));
        Pc6.setText(String.valueOf(mass[13]));

        if(!zeroB.equals(""))
            TvZero.setText(zeroB);
        if(!zeroB1.equals(""))
            TvZero.append("("+zeroB1+")");
        if( (zeroB.length())<2 ) {
            TrZero.setBackground(getResources().getDrawable(R.drawable.bg_zerocell_colored_red));
        }else if ((zeroB.length())==2) {
            TrZero.setBackground(getResources().getDrawable(R.drawable.bg_zerocell_colored_yellow));
        }else {
            TrZero.setBackground(getResources().getDrawable(R.drawable.bg_zerocell_colored_green));
        }

        if(!oneB.equals(""))
            TvOne.setText(oneB);
        if(!oneB1.equals(""))
            TvOne.append("("+oneB1+")");
        if( (oneB.length())<3 ){
            TvOne.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (oneB.length())==3 ){
            TvOne.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvOne.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!twoB.equals(""))
            TvTwo.setText(twoB);
        if(!twoB1.equals(""))
            TvTwo.append("("+twoB1+")");
        if( (twoB.length())<3 ){
            TvTwo.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (twoB.length())==3 ){
            TvTwo.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvTwo.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!threeB.equals(""))
            TvThree.setText(threeB);
        if(!threeB1.equals(""))
            TvThree.append("("+threeB1+")");
        if( (threeB.length())<2 ){
            TvThree.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (threeB.length())==2 ){
            TvThree.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvThree.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!fourB.equals(""))
            TvFour.setText(fourB);
        if(!fourB1.equals(""))
            TvFour.append("("+fourB1+")");
        if( (fourB.length())<1 ){
            TvFour.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (fourB.length())==1 ){
            TvFour.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvFour.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!fiveB.equals(""))
            TvFive.setText(fiveB);
        if(!fiveB1.equals(""))
            TvFive.append("("+fiveB1+")");
        if( (fiveB.length())<1 ){
            TvFive.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (fiveB.length())==1 ){
            TvFive.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvFive.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!sixB.equals(""))
            TvSix.setText(sixB);
        if(!sixB1.equals(""))
            TvSix.append("("+sixB1+")");
        if( (sixB.length())<1 ){
            TvSix.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (sixB.length())==1 ){
            TvSix.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvSix.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!sevenB.equals(""))
            TvSeven.setText(sevenB);
        if(!sevenB1.equals(""))
            TvSeven.append("("+sevenB1+")");
        if( (sevenB.length())<1 ){
            TvSeven.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (sevenB.length())==1 ){
            TvSeven.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvSeven.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!eightB.equals(""))
            TvEight.setText(eightB);
        if(!eightB1.equals(""))
            TvEight.append("("+eightB1+")");
        if( (eightB.length())<1 ){
            TvEight.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (eightB.length())==1 ){
            TvEight.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvEight.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!nineB.equals(""))
            TvNine.setText(nineB);
        if(!nineB1.equals(""))
            TvNine.append("("+nineB1+")");
        if( (nineB.length())<1 ){
            TvNine.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (nineB.length())==1 ){
            TvNine.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvNine.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!tenB.equals(""))
            TvTen.setText(tenB);
        if(!tenB1.equals(""))
            TvTen.append("("+tenB1+")");
        if( (tenB.length())<2 ){
            TvTen.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (tenB.length())==2 ){
            TvTen.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvTen.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!elevenB.equals(""))
            TvEleven.setText(elevenB);
        if(!elevenB1.equals(""))
            TvEleven.append("("+elevenB1+")");
        if( (elevenB.length())<2 ){
            TvEleven.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (elevenB.length())==2 ){
            TvEleven.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvEleven.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        if(!twelveB.equals(""))
            TvTwelve.setText(twelveB);
        if(!twelveB1.equals(""))
            TvTwelve.append("("+twelveB1+")");
        if( (twelveB.length())<2 ){
            TvTwelve.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_red));
        }else if( (twelveB.length())==2 ){
            TvTwelve.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_yellow));
        }else {
            TvTwelve.setBackground(getResources().getDrawable(R.drawable.bg_cell_colored_green));
        }

        TvSum1.append(String.valueOf(OverTwelve(sum1))+"("+String.valueOf(OverTwelve(sum1d))+")");
        TvSum2.append(String.valueOf(OverTwelve(sum2))+"("+String.valueOf(OverTwelve(sum2d))+")");
        TvSum3.append(String.valueOf(OverTwelve(sum3))+"("+String.valueOf(OverTwelve(sum3d))+")");
        TvSum4.append(String.valueOf(OverTwelve(sum4))+"("+String.valueOf(OverTwelve(sum4d))+")");

        zeroB=""; fiveB=""; twoB=""; oneB=""; threeB=""; fourB=""; sixB=""; sevenB=""; eightB=""; nineB=""; tenB=""; elevenB=""; twelveB="";
        zeroB1=""; fiveB1=""; twoB1=""; oneB1=""; threeB1=""; fourB1=""; sixB1=""; sevenB1=""; eightB1=""; nineB1=""; tenB1=""; elevenB1=""; twelveB1="";
        sum1=sum2=sum3=sum4=0;
        sum1d=sum2d=sum3d=sum4d=0;
        calculationForMonth(YearArray, MonthArray);
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 31; j++) {
                System.out.print(monthCalc[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int OverTwelve(int a){
        if (a>12){
            int res = OverTwelve(SumOfNum(a));
            return res;
        }else
            return a;
    }
    public static int SumOfNum(int a){
        int sum=0;
        while(a!=0){
            sum += (a%10);
            a/=10;
        }
        return sum;
    }

    public void ZapolnDop(int a, byte id){
        if (a>9) {
            while (a != 0) {
                Zapoln(a % 10, id);
                a /= 10;
            }
        }
    }

    public void Zapoln(int aRow, byte id){

        String a;
        if (id ==12 || id == 13) {
            a = String.valueOf(aRow);
            if (aRow == 0) {
                zeroB1 += a;
            }else if (aRow == 1) {
                oneB1 += a;
                sum1d+=aRow;
            }else if (aRow == 2) {
                twoB1 += a;
                sum1d+=aRow;
            }else if (aRow == 3) {
                threeB1 += a;
                sum1d+=aRow;
            }else if (aRow == 4) {
                fourB1 += a;
                sum2d+=aRow;
            }else if (aRow == 5) {
                fiveB1 += a;
                sum2d+=aRow;
            }else if (aRow == 6) {
                sixB1 += a;
                sum2d+=aRow;
            }else if (aRow == 7) {
                sevenB1 += a;
                sum3d+=aRow;
            }else if (aRow == 8) {
                eightB1 += a;
                sum3d+=aRow;
            }else if (aRow == 9) {
                nineB1 += a;
                sum3d+=aRow;
            }else if (aRow == 10) {
                tenB1 += a;
                sum4d+=aRow;
            }else if (aRow == 11) {
                elevenB1 += a;
                sum4d+=aRow;
            }else if (aRow == 12) {
                twelveB1 += a;
                sum4d+=aRow;
            }
        } else {
            a = String.valueOf(aRow);
            if (aRow == 0) {
                zeroB += a;
            } else if (aRow == 1) {
                oneB += a;
                sum1+=aRow;
            } else if (aRow == 2) {
                twoB += a;
                sum1+=aRow;
            } else if (aRow == 3) {
                threeB += a;
                sum1+=aRow;
            } else if (aRow == 4) {
                fourB += a;
                sum2+=aRow;
            } else if (aRow == 5) {
                fiveB += a;
                sum2+=aRow;
            } else if (aRow == 6) {
                sixB += a;
                sum2+=aRow;
            } else if (aRow == 7) {
                sevenB += a;
                sum3+=aRow;
            } else if (aRow == 8) {
                eightB += a;
                sum3+=aRow;
            } else if (aRow == 9) {
                nineB += a;
                sum3+=aRow;
            } else if (aRow == 10) {
                tenB += a;
                sum4+=aRow;
            } else if (aRow == 11) {
                elevenB += a;
                sum4+=aRow;
            } else if (aRow == 12) {
                twelveB += a;
                sum4+=aRow;
            }
        }
    }


    public void OpenDopTv(View view) {
        if(isOpened){
            isOpened=false;
            TvDopRes.setHeight(0);
        }
        else if(!isOpened && isCanBEOpened) {
            isOpened=true;
            TvDopRes.setHeight(330);
        }
    }
}
