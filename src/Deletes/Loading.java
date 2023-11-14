package Deletes;

public class Loading {
    public static void loading() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Loading");
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    System.out.println("Error + " + e);
                }

                System.out.println();
            }
        });

        thread.start();
    }
}
