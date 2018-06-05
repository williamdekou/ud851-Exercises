package com.example.android.boardingpass;

/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.boardingpass.databinding.ActivityMainBinding;
import com.example.android.boardingpass.utilities.FakeDataUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //COMPLETED (3) Create a data binding instance called mBinding of type ActivityMainBinding
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // COMPLETED (4) Set the Content View using DataBindingUtil to the activity_main layout
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // COMPLETED (5) Load a BoardingPassInfo object with fake data using FakeDataUtils
        BoardingPassInfo boardingPassInfo = FakeDataUtils.generateFakeBoardingPassInfo();
        // COMPLETED (9) Call displayBoardingPassInfo and pass the fake BoardingInfo instance
        displayBoardingPassInfo(boardingPassInfo);
    }

    private void displayBoardingPassInfo(BoardingPassInfo info) {

        // COMPLETED (6) Use mBinding to set the Text in all the textViews using the data in info
        mainBinding.textViewPassengerName.setText(info.passengerName);
        mainBinding.textViewOriginAirport.setText(info.originCode);
        mainBinding.textViewFlightCode.setText(info.flightCode);
        mainBinding.textViewDestinationAirport.setText(info.destCode);
        // COMPLETED (7) Use a SimpleDateFormat formatter to set the formatted value in time text views
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a", Locale.getDefault());

        mainBinding.textViewArrivalTime.setText(format.format(info.arrivalTime));
        mainBinding.textViewDepartureTime.setText(format.format(info.arrivalTime));
        mainBinding.textViewDepartureTime.setText(format.format(info.departureTime));
        mainBinding.textViewBoardingTime.setText(format.format(info.boardingTime));

        // COMPLETED (8) Use TimeUnit methods to format the total minutes until boarding
        long totalMinutesUntilBoading = info.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalMinutesUntilBoading);
        long minutesLessHoursUntilBoarding =
                totalMinutesUntilBoading - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String hoursAndMinutesUntilBoarding = hoursUntilBoarding + ":" + minutesLessHoursUntilBoarding;

        mainBinding.textViewBoardingInCountdown.setText(hoursAndMinutesUntilBoarding);
        mainBinding.textViewTerminal.setText(info.departureTerminal);
        mainBinding.textViewSeat.setText(info.seatNumber);
        mainBinding.textViewGate.setText(info.departureGate);

    }
}

