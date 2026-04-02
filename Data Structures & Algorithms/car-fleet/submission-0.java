class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int brojFlota =0;
        double vremePoslednjeg = 0;

        int i=0;

        while (i<position.length) {
            boolean izmenjeno = false;
            for (int k = 0; k < position.length-i-1; k++) {
                if (position[k]>position[k+1]) {
                    int kopija = position[k];
                    int kopBr = speed[k];
                    position[k] = position[k+1];
                    position[k+1]=kopija;
                    izmenjeno=true;
                    speed[k] = speed[k+1];
                    speed[k+1] = kopBr;


                }
            }
            i++;

            if (!izmenjeno)
                break;
        }

        for (i=position.length-1;i>=0;i--) {
            double trenutnoVreme = (double)(target - position[i])/speed[i];
            System.out.println(vremePoslednjeg + ": " + trenutnoVreme + "  POZICIJA: " + position[i] + " BRZINA: "+ speed[i]);

            if (vremePoslednjeg==0 || trenutnoVreme>vremePoslednjeg) {
                vremePoslednjeg=trenutnoVreme;
                brojFlota+=1;
            }
        }

        return brojFlota;
    }
}
