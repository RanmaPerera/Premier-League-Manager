package com.company;

import java.io.Serializable;
import java.util.Comparator;

public class StatisticsOrderingComparator implements Comparator<FootballClub>, Serializable {
    @Override
    public int compare (FootballClub tp01 , FootballClub tp02) {
        if (tp01.getTotalPoints() > tp02.getTotalPoints()) {
            return -1;
        }else {
            if (tp01.getTotalPoints()< tp02.getTotalPoints()){
                return 1;
            }else {
                int goalsDifference01 = tp01.getTotalScoredGoals() - tp01.getTotalReceivedGoals();
                int goalsDifference02 = tp02.getTotalScoredGoals() - tp02.getTotalReceivedGoals();
                if (goalsDifference01 > goalsDifference02){
                    return -1;
                }else {
                    if (goalsDifference01 < goalsDifference02){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        }
    }
}
