package circuitly;

/**
 * chipTracker calculates the output of the chip every time the breadboard updates and returns the updated column states. 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class chipTracker {
    double start, end;
    
    ArrayList <createChip.createAndChip> andChipList = new ArrayList<>();
    ArrayList <createChip.createNandChip> nandChipList = new ArrayList<>();
    ArrayList <createChip.createOrChip> orChipList = new ArrayList<>();
    ArrayList <createChip.createXorChip> xorChipList = new ArrayList<>();
    ArrayList <createChip.createNorChip> norChipList = new ArrayList<>();
    ArrayList <createChip.createNotChip> notChipList = new ArrayList<>();
    ArrayList <createChip.createAndFourChip> andFourChipList = new ArrayList<>();
    ArrayList <createChip.createNandFourChip> nandFourChipList = new ArrayList<>();
    
    ArrayList <stateTracker.columnCreationGroupOne> columnStatesGroupOneList;
    ArrayList <stateTracker.columnCreationGroupTwo> columnStatesGroupTwoList;
    ArrayList <stateTracker.columnCreationOutputs> outputs;
    
    stateTracker.columnCreationGroupOne[] compareList = new stateTracker.columnCreationGroupOne[7];
    stateTracker.columnCreationGroupTwo[] compareListTwo = new stateTracker.columnCreationGroupTwo[7];
    
    stateTracker.columnCreationGroupOne[] wiresToUpdateGroupOneOne = new stateTracker.columnCreationGroupOne[1000];
    stateTracker.columnCreationGroupOne[] wiresToUpdateGroupOneTwo = new stateTracker.columnCreationGroupOne[1000];
    stateTracker.columnCreationGroupTwo[] wiresToUpdateGroupTwoOne = new stateTracker.columnCreationGroupTwo[1000];
    stateTracker.columnCreationGroupTwo[] wiresToUpdateGroupTwoTwo = new stateTracker.columnCreationGroupTwo[1000];
    
    int oneOneState, twoOneState;
    
    ArrayList <Line> wireList;
    
    Line[] toBeUpdatedOneOne = new Line[1000];
    Line[] toBeUpdatedTwoOne = new Line[1000];
    
    int inArray;
    int z = 1;int y = 1;
    
    public void getInformation(ArrayList <stateTracker.columnCreationGroupOne> groupOne, ArrayList <stateTracker.columnCreationGroupTwo> groupTwo,
            ArrayList <createChip.createAndChip> andChip, ArrayList <createChip.createNandChip> nandChip, ArrayList <createChip.createOrChip> orChip,
            ArrayList <createChip.createXorChip> xorChip, ArrayList <createChip.createNorChip> norChip, ArrayList <createChip.createNotChip> notChip,
            ArrayList <createChip.createAndFourChip> andFourChip, ArrayList <createChip.createNandFourChip> nandFourChip, ArrayList <Line> createWireList, 
            ArrayList <stateTracker.columnCreationOutputs> outs){
        
        columnStatesGroupOneList = groupOne;
        columnStatesGroupTwoList = groupTwo;
        outputs = outs;
        
        wireList = createWireList;
        
        andChipList = andChip;
        nandChipList = nandChip;
        orChipList = orChip;
        xorChipList = xorChip;
        norChipList = norChip;
        notChipList = notChip;
        andFourChipList = andFourChip;
        nandFourChipList = nandFourChip;
        
        if(andChipList.size() > 0){
            getAndColumns();
        }
        if(nandChipList.size() > 0){
            getNandColumns();
        }
        if(orChipList.size() > 0){
            getOrColumns();
        }
        if(xorChipList.size() > 0){
            getXorColumns();
        }
        if(norChipList.size() > 0){
            getNorColumns();
        }
        if(notChipList.size() > 0){
            getNotColumns();
        }
        if(andFourChipList.size() > 0){
            getAndFourColumns();
        }
        if(nandFourChipList.size() > 0){
            getNandFourColumns();
        }
    }

// all of these get the columns that need to be updated with tehir specific logic    
    public void getAndColumns(){
        for(int i = 0; i < andChipList.size(); i++){
            int k = 0;
            double tempX = andChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setAndChips();
                    j = 65;
                }
            }
        }
    }
    public void getNandColumns(){
        for(int i = 0; i < nandChipList.size(); i++){
            int k = 0;
            double tempX = nandChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setNandChips();
                    j = 65;
                }
            }
        }
    }
    public void getOrColumns(){
        for(int i = 0; i < orChipList.size(); i++){
            int k = 0;
            double tempX = orChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setOrChips();
                    j = 65;
                }
            }
        }
    }
    public void getXorColumns(){
        for(int i = 0; i < xorChipList.size(); i++){
            int k = 0;
            double tempX = xorChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setXorChips();
                    j = 65;
                }
            }
        }
    }
    public void getNorColumns(){
        for(int i = 0; i < norChipList.size(); i++){
            int k = 0;
            double tempX = norChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setNorChips();
                    j = 65;
                }
            }
        }
    }
    public void getNotColumns(){
        for(int i = 0; i < notChipList.size(); i++){
            int k = 0;
            double tempX = notChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setNotChips();
                    j = 65;
                }
            }
        }
    }
    public void getAndFourColumns(){
        for(int i = 0; i < andFourChipList.size(); i++){
            int k = 0;
            double tempX = andFourChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setAndFourChips();
                    j = 65;
                }
            }
        }
    }
    public void getNandFourColumns(){
        for(int i = 0; i < nandFourChipList.size(); i++){
            int k = 0;
            double tempX = nandFourChipList.get(i).getX();
            for(int j = 0; j < 65; j++){
                if(columnStatesGroupOneList.get(j).getX() == tempX){
                    compareList[0] = columnStatesGroupOneList.get(j);
                    compareList[1] = columnStatesGroupOneList.get(j + 1);
                    compareList[2] = columnStatesGroupOneList.get(j + 2);
                    compareList[3] = columnStatesGroupOneList.get(j + 3);
                    compareList[4] = columnStatesGroupOneList.get(j + 4);
                    compareList[5] = columnStatesGroupOneList.get(j + 5);
                    compareList[6] = columnStatesGroupOneList.get(j + 6);
                    compareListTwo[0] = columnStatesGroupTwoList.get(j);
                    compareListTwo[1] = columnStatesGroupTwoList.get(j + 1);
                    compareListTwo[2] = columnStatesGroupTwoList.get(j + 2);
                    compareListTwo[3] = columnStatesGroupTwoList.get(j + 3);
                    compareListTwo[4] = columnStatesGroupTwoList.get(j + 4);
                    compareListTwo[5] = columnStatesGroupTwoList.get(j + 5);
                    compareListTwo[6] = columnStatesGroupTwoList.get(j + 6);
                    setNandFourChips();
                    j = 65;
                }
            }
        }
    }
// all of these set the columns that need to be updated with tehir specific logic        
    public void setAndChips(){
        if(compareList[0].getState() == 1){
            if(compareList[1].getState() == 1 && compareList[2].getState() == 1){
                compareList[3].setState(1);
            }
            else{
                compareList[3].setState(0);
            }

            if(compareList[4].getState() == 1 && compareList[5].getState() == 1){
                compareList[6].setState(1);
            }
            else{
                compareList[6].setState(0);
            }
            
            if(compareListTwo[0].getState() == 1 && compareListTwo[1].getState() == 1){
                compareListTwo[2].setState(1);
            }
            else{
                compareListTwo[2].setState(0);
            }
            
            if(compareListTwo[3].getState() == 1 && compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(1);
            }
            else{
                compareListTwo[5].setState(0);
            }
        }
        
        else{
            compareList[3].setState(0);
            compareList[6].setState(0);
            compareListTwo[2].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 3).setState(compareList[3].getState());
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState());
                
                wiresToUpdateGroupOneOne[0] = columnStatesGroupOneList.get(i + 3);
                oneOneState = columnStatesGroupOneList.get(i + 3).getState();
                getConnectedColumnsOneOne();
                
                wiresToUpdateGroupOneTwo[0] = columnStatesGroupOneList.get(i + 6);
                
                columnStatesGroupTwoList.get(i + 2).setState(compareListTwo[2].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
                
                wiresToUpdateGroupTwoOne[0] = columnStatesGroupTwoList.get(i + 2);
                twoOneState = columnStatesGroupTwoList.get(i + 2).getState();
                getConnectedColumnsTwoOne();
                
                wiresToUpdateGroupTwoTwo[0] = columnStatesGroupTwoList.get(i + 5);
                
                
            }
        }
    }
    public void setNandChips(){
        if(compareList[0].getState() == 1){
            if(compareList[1].getState() == 1 && compareList[2].getState() == 1){
                compareList[3].setState(0);
            }
            else{
                compareList[3].setState(1);
            }

            if(compareList[4].getState() == 1 && compareList[5].getState() == 1){
                compareList[6].setState(0);
            }
            else{
                compareList[6].setState(1);
            }
            
            if(compareListTwo[0].getState() == 1 && compareListTwo[1].getState() == 1){
                compareListTwo[2].setState(0);
            }
            else{
                compareListTwo[2].setState(1);
            }
            
            if(compareListTwo[3].getState() == 1 && compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(0);
            }
            else{
                compareListTwo[5].setState(1);
            }
        }
        
        else{
            compareList[3].setState(0);
            compareList[6].setState(0);
            compareListTwo[2].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 3).setState(compareList[3].getState());
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState()); 
                columnStatesGroupTwoList.get(i + 2).setState(compareListTwo[2].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }
    public void setOrChips(){
        if(compareList[0].getState() == 1){
            if(compareList[1].getState() == 1 || compareList[2].getState() == 1){
                compareList[3].setState(1);
            }
            else{
                compareList[3].setState(0);
            }

            if(compareList[4].getState() == 1 || compareList[5].getState() == 1){
                compareList[6].setState(1);
            }
            else{
                compareList[6].setState(0);
            }
            
            if(compareListTwo[0].getState() == 1 || compareListTwo[1].getState() == 1){
                compareListTwo[2].setState(1);
            }
            else{
                compareListTwo[2].setState(0);
            }
            
            if(compareListTwo[3].getState() == 1 || compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(1);
            }
            else{
                compareListTwo[5].setState(0);
            }
        }
        
        else{
            compareList[3].setState(0);
            compareList[6].setState(0);
            compareListTwo[2].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 3).setState(compareList[3].getState());
                wiresToUpdateGroupOneOne[0] = columnStatesGroupOneList.get(i + 3);
                oneOneState = columnStatesGroupOneList.get(i + 3).getState();
                getConnectedColumnsOneOne();
                
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState()); 
                columnStatesGroupTwoList.get(i + 2).setState(compareListTwo[2].getState());
                wiresToUpdateGroupTwoOne[0] = columnStatesGroupTwoList.get(i + 2);
                twoOneState = columnStatesGroupTwoList.get(i + 2).getState();
                getConnectedColumnsTwoOne();
                
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }
    public void setNorChips(){
        if(compareList[0].getState() == 1){
            if(compareList[1].getState() == 1 || compareList[2].getState() == 1){
                compareList[3].setState(0);
            }
            else{
                compareList[3].setState(1);
            }

            if(compareList[4].getState() == 1 || compareList[5].getState() == 1){
                compareList[6].setState(0);
            }
            else{
                compareList[6].setState(1);
            }
            
            if(compareListTwo[0].getState() == 1 || compareListTwo[1].getState() == 1){
                compareListTwo[2].setState(0);
            }
            else{
                compareListTwo[2].setState(1);
            }
            
            if(compareListTwo[3].getState() == 1 || compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(0);
            }
            else{
                compareListTwo[5].setState(1);
            }
        }
        
        else{
            compareList[3].setState(0);
            compareList[6].setState(0);
            compareListTwo[2].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 3).setState(compareList[3].getState());
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState()); 
                columnStatesGroupTwoList.get(i + 2).setState(compareListTwo[2].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }
    public void setXorChips(){
        if(compareList[0].getState() == 1){
// Y1            
            if(compareList[1].getState() == 1 && compareList[2].getState() == 1){
                compareList[3].setState(0);
            }
            else if(compareList[1].getState() == 0 && compareList[2].getState() == 0){
                compareList[3].setState(0);
            }
            else{
                compareList[3].setState(1);
            }
// Y2
            if(compareList[4].getState() == 1 && compareList[5].getState() == 1){
                compareList[6].setState(0);
            }
            else if(compareList[4].getState() == 0 && compareList[5].getState() == 0){
                compareList[6].setState(0);
            }
            else{
                compareList[6].setState(1);
            }
// Y3            
            if(compareListTwo[0].getState() == 1 && compareListTwo[1].getState() == 1){
                compareListTwo[2].setState(0);
            }
            else if(compareListTwo[0].getState() == 0 && compareListTwo[1].getState() == 0){
                compareListTwo[2].setState(0);
            }
            else{
                compareListTwo[2].setState(1);
            }
// Y4            
            if(compareListTwo[3].getState() == 1 && compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(0);
            }
            else if(compareListTwo[3].getState() == 0 && compareListTwo[4].getState() == 0){
                compareListTwo[5].setState(0);
            }
            else{
                compareListTwo[5].setState(1);
            }
        }
        
        else{
            compareList[3].setState(0);
            compareList[6].setState(0);
            compareListTwo[2].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 3).setState(compareList[3].getState());
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState()); 
                columnStatesGroupTwoList.get(i + 2).setState(compareListTwo[2].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }
    public void setNotChips(){
        if(compareList[0].getState() == 1){
// Y1            
            if(compareList[1].getState() == 1){
                compareList[2].setState(0);
            }
            else{
                compareList[2].setState(1);
            }
// Y2
            if(compareList[3].getState() == 1){
                compareList[4].setState(0);
            }
            else{
                compareList[4].setState(1);
            }
// Y3            
            if(compareList[5].getState() == 1){
                compareList[6].setState(0);
            }
            else{
                compareList[6].setState(1);
            }
// Y4            
            if(compareListTwo[0].getState() == 1){
                compareListTwo[1].setState(0);
            }
            else{
                compareListTwo[1].setState(1);
            }
// Y5            
            if(compareListTwo[2].getState() == 1){
                compareListTwo[3].setState(0);
            }
            else{
                compareListTwo[3].setState(1);
            }  
// Y4            
            if(compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(0);
            }
            else{
                compareListTwo[5].setState(1);
            }            
        }
        
        else{
            compareList[2].setState(0);
            compareList[4].setState(0);
            compareList[6].setState(0);
            
            compareListTwo[1].setState(0);
            compareListTwo[3].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 2).setState(compareList[2].getState());
                columnStatesGroupOneList.get(i + 4).setState(compareList[4].getState()); 
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState());
                
                columnStatesGroupTwoList.get(i + 1).setState(compareListTwo[1].getState());
                columnStatesGroupTwoList.get(i + 3).setState(compareListTwo[3].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }
    public void setAndFourChips(){
        if(compareList[0].getState() == 1){
// Y1            
            if(compareList[1].getState() == 1 && compareList[2].getState() == 1 && compareList[4].getState() == 1 && compareList[5].getState() == 1){
                compareList[6].setState(1);
            }
            else{
                compareList[6].setState(0);
            }
// Y2            
            if(compareListTwo[0].getState() == 1 && compareListTwo[1].getState() == 1 && compareListTwo[3].getState() == 1 && compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(1);
            }
            else{
                compareListTwo[5].setState(0);
            }
        }
        
        else{
            compareList[6].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }
    public void setNandFourChips(){
        if(compareList[0].getState() == 1){
// Y1            
            if(compareList[1].getState() == 1 && compareList[2].getState() == 1 && compareList[4].getState() == 1 && compareList[5].getState() == 1){
                compareList[6].setState(0);
            }
            else{
                compareList[6].setState(1);
            }
// Y2            
            if(compareListTwo[0].getState() == 1 && compareListTwo[1].getState() == 1 && compareListTwo[3].getState() == 1 && compareListTwo[4].getState() == 1){
                compareListTwo[5].setState(0);
            }
            else{
                compareListTwo[5].setState(1);
            }
        }
        
        else{
            compareList[6].setState(0);
            compareListTwo[5].setState(0);
        }
        
        for(int i = 0; i < 65; i++ ){
            if(compareList[0].getX() == columnStatesGroupOneList.get(i).getX()){
                columnStatesGroupOneList.get(i + 6).setState(compareList[6].getState());
                columnStatesGroupTwoList.get(i + 5).setState(compareListTwo[5].getState());
            }
        }
    }

// if there are wires conntected to the new updated wires update those as well in the first group of breadbaord holes  
    public void getConnectedColumnsOneOne(){
        double check = wiresToUpdateGroupOneOne[0].getX() + 5;
//        System.out.println("Column X:   " + check);
        for(int i = 0; i < wireList.size(); i++){
            if(check == wireList.get(i).getStartX() || wireList.get(i).getEndX() == check){
                toBeUpdatedOneOne[0] = wireList.get(i);
                getConnectedWiresGroupOneOne(0);
            }

        }
    }
    public void getConnectedWiresGroupOneOne(int n){
        if(n < wireList.size()){
            for(int i = 0; i < wireList.size(); i++){
                if((toBeUpdatedOneOne[n].getStartX() == wireList.get(i).getStartX() ||  toBeUpdatedOneOne[n].getStartX() == wireList.get(i).getEndX() || 
                        toBeUpdatedOneOne[n].getEndX() == wireList.get(i).getEndX() || toBeUpdatedOneOne[n].getEndX() == wireList.get(i).getStartX()) && 
                        (toBeUpdatedOneOne[n].getStartX() != wireList.get(i).getStartX() && toBeUpdatedOneOne[n].getEndX() != wireList.get(i).getEndX())){
                    double tempStart = wireList.get(i).getStartX();
                    double tempEnd = wireList.get(i).getEndX();
                    
                    boolean notDuplicate = true;
                    for(int j = 0; j < toBeUpdatedOneOne.length; j++){
                        if(toBeUpdatedOneOne[j] != null){
                            if(tempStart == toBeUpdatedOneOne[j].getStartX() && tempEnd == toBeUpdatedOneOne[j].getEndX()){
                                notDuplicate = false;
                                j = toBeUpdatedOneOne.length + 1;
                            }
                        }
                    }
                    
                    if(notDuplicate == true){
                        toBeUpdatedOneOne[z] = wireList.get(i);
                        z++;
                    }
                    
                }
            }
            
            n++;
            if(toBeUpdatedOneOne[n] != null){
                System.out.println("------New N-----");
                getConnectedWiresGroupOneOne(n);
            }
            else{
                
                getConnectedWiresGroupOneOne(wireList.size() + 1);
            }
        }
        
        else{
            for(int i = 0; i < toBeUpdatedOneOne.length; i++){
                if(toBeUpdatedOneOne[i] != null){
                    System.out.println("In List: " + toBeUpdatedOneOne[i].getStartX() + "           " + toBeUpdatedOneOne[i].getEndX()); 
                    
                    for(int j = 0; j < 65; j++){
                        if(toBeUpdatedOneOne[j] != null){
                            double startX = toBeUpdatedOneOne[j].getStartX();
                            double endX = toBeUpdatedOneOne[j].getEndX();

                            if(startX == columnStatesGroupOneList.get(i).getX() || endX == columnStatesGroupOneList.get(i).getX()){
                                columnStatesGroupOneList.get(i).setState(oneOneState);
                            }
                        }
                    }
                }
            }
        }
    }

// if there are wires conntected to the new updated wires update those as well in the second group of breadbaord holes     
    public void getConnectedColumnsTwoOne(){
        double check = wiresToUpdateGroupTwoOne[0].getX() + 5;
        for(int i = 0; i < wireList.size(); i++){
            if(check == wireList.get(i).getStartX() || wireList.get(i).getEndX() == check){
                toBeUpdatedTwoOne[0] = wireList.get(i);
                getConnectedWiresGroupTwoOne(0);
            }

        }
    }        
    public void getConnectedWiresGroupTwoOne(int n){
        if(n < wireList.size()){
            for(int i = 0; i < wireList.size(); i++){
                if((toBeUpdatedTwoOne[n].getStartX() == wireList.get(i).getStartX() ||  toBeUpdatedTwoOne[n].getStartX() == wireList.get(i).getEndX() || 
                        toBeUpdatedTwoOne[n].getEndX() == wireList.get(i).getEndX() || toBeUpdatedTwoOne[n].getEndX() == wireList.get(i).getStartX())){
                    double tempStart = wireList.get(i).getStartX();
                    double tempEnd = wireList.get(i).getEndX();
                    
                    boolean notDuplicate = true;
                    for(int j = 0; j < toBeUpdatedTwoOne.length; j++){
                        if(toBeUpdatedTwoOne[j] != null){
                            if(tempStart == toBeUpdatedTwoOne[j].getStartX() && tempEnd == toBeUpdatedTwoOne[j].getEndX()){
                                notDuplicate = false;
                                j = toBeUpdatedTwoOne.length + 1;
                            }
                        }
                    }
                    
                    if(notDuplicate == true){
                        toBeUpdatedTwoOne[y] = wireList.get(i);
                        y++;
                    }
                    
                }
            }
            
            n++;
            if(toBeUpdatedTwoOne[n] != null){
                System.out.println("------New N-----");
                getConnectedWiresGroupTwoOne(n);
            }
            else{
                
                getConnectedWiresGroupTwoOne(wireList.size() + 1);
            }
        }
        
        else{
            for(int i = 0; i < toBeUpdatedTwoOne.length; i++){
                if(toBeUpdatedTwoOne[i] != null){
                    System.out.println("In List: " + toBeUpdatedTwoOne[i].getStartX() + "           " + toBeUpdatedTwoOne[i].getEndX()); 
                    
                    for(int j = 0; j < 65; j++){
                            double startX = toBeUpdatedTwoOne[i].getStartX();
                            double endX = toBeUpdatedTwoOne[i].getEndX();
                            
                            double startY = toBeUpdatedTwoOne[i].getStartY();
                            double endY = toBeUpdatedTwoOne[i].getEndY();
                            
                            if((startY >= 245 && startY <= 305) || (endY >= 245 && endY <= 305)){
                                if(startX == (columnStatesGroupTwoList.get(j).getX() + 5)|| endX == (columnStatesGroupTwoList.get(j).getX() + 5)){
                                    columnStatesGroupTwoList.get(j).setState(twoOneState);
                                    System.out.println(columnStatesGroupTwoList.get(j).getState());
                                }
                            }
                            
                            if(startY >= 550|| endY >= 550){
                                if(j < outputs.size()){
                                if(startX == (outputs.get(j).getX() + 5)|| endX == (outputs.get(j).getX() + 5)){
                                    outputs.get(j).setState(twoOneState);
                                    System.out.println(outputs.get(j).getState());
                                }
                                }
                            }
                            
                        }
                    }
                }
            }
        }
    }



