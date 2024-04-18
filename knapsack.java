import java.util.Scanner;
public class knapsack {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int[] array = new int[5];
        int[] profits = {10,5,15,7,6,18,3};
        int[] weights ={2,3,5,7,1,4,1};
        int maximum_weight=15;
        float total_profit=0;
        float[] ratios = new float[profits.length];
        for(int i=0;i<weights.length;i++){
            ratios[i]= (float) profits[i]/weights[i];
        }
        for(int j=0;j<weights.length-1;j++){
            for(int k=j+1; k<weights.length;k++){
                if(ratios[j]<ratios[k]){
                    float temp1 = ratios[j];
                    int temp2 = weights[j];
                    int temp3 =profits[j];
                    ratios[j] = ratios[k];
                    weights[j]=weights[k];
                    profits[j]=profits[k];
                    ratios[k]=temp1;
                    weights[k]=temp2;
                    profits[k]=temp3;
                }
            }
        }
        System.out.print("profits : " );
        for (int f : profits) {
            System.out.print(f+" ");
        }
        System.out.println();
        System.out.print("weights : ");
        for (int f : weights) {
            System.out.print(f+" ");
        }
        System.out.println();
        System.out.print("ratios : ");
        for (float f : ratios) {
            System.out.print(f+" ");
        }
        int pointer=0;
        int available_space=maximum_weight;
        while(available_space>0){
           if(available_space<weights[pointer]){
              total_profit += (float) (ratios[pointer]*available_space);
              available_space-=weights[pointer];
              pointer++;
           }
           else{
            total_profit+=profits[pointer];
            available_space-=weights[pointer];
            pointer++;
           }
        }
        System.out.println();
        System.out.println("total profit = "+total_profit);


    }
    
}