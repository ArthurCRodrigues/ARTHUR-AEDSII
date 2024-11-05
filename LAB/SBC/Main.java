import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder result = new StringBuilder();

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line.trim());
            int currentTime = 0;
            long totalWaitTime = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int requestTime = Integer.parseInt(st.nextToken());
                int duration = Integer.parseInt(st.nextToken());

                // If the current time is less than the request time, fast forward time
                if (currentTime < requestTime) {
                    currentTime = requestTime;
                }

                // Calculate waiting time for this process
                totalWaitTime += (currentTime - requestTime);

                // Advance the current time by the duration of this process
                currentTime += duration;
            }

            // Append result for this test case
            result.append(totalWaitTime).append("\n");
        }

        // Output all results
        System.out.print(result);
    }
}
