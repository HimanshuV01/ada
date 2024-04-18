public class job_sequencing_greedy {
    public static void main(String[] args) {
        int[] jobs = {1,2,3,4,5,6,7};
        int[] profits ={30,20,12,35,25,15,5};
        int[] deadlines ={4,2,1,3,4,3,2};
        
        int max_time_deadline=0;
        for(int i =0; i<jobs.length-1;i++){
             for(int j=i+1;j<jobs.length;j++){
                if(profits[i]<profits[j]){
                    int temp1 = jobs[i];
                    int temp2= profits[i];
                    int temp3 = deadlines[i];
                    jobs[i]=jobs[j];
                    profits[i]=profits[j];
                    deadlines[i]=deadlines[j];
                    jobs[j]=temp1;
                    profits[j]=temp2;
                    deadlines[j]=temp3;

                
            }
            
        }
        if(deadlines[i]>max_time_deadline){
            max_time_deadline=deadlines[i];
        }
        
    }
   
    int[] available = new int[max_time_deadline];
    int total_profit=0;
    for(int k=0; k<jobs.length;k++){
        int pointer =deadlines[k]-1;
        while(pointer>-1){
        if(available[pointer]==0){
            available[pointer]=1;
            total_profit+=profits[k];
            break;
        }
        else{
            pointer-=1;
        }
    }
    }
    System.out.println("total profit  = "+total_profit);
}

}
