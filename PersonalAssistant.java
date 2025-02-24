import android.content.Context;
import android.os.AsyncTask;
import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class PersonalAssistant implements AIListener {
    private AIDataService aiDataService;

    public PersonalAssistant(Context context) {
        final AIConfiguration config = new AIConfiguration(
                "YOUR_CLIENT_ACCESS_TOKEN",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System
        );
        aiDataService = new AIDataService(context, config);
    }

    public void sendQuery(String query) {
        AIRequest aiRequest = new AIRequest();
        aiRequest.setQuery(query);

        new AsyncTask<AIRequest, Void, AIResponse>() {
            @Override
            protected AIResponse doInBackground(AIRequest... requests) {
                try {
                    return aiDataService.request(requests[0]);
                } catch (AIServiceException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(AIResponse aiResponse) {
                if (aiResponse != null) {
                    // Handle the response
                }
            }
        }.execute(aiRequest);
    }

    @Override
    public void onResult(AIResponse result) {
        // Handle the result
    }

    @Override
    public void onError(ai.api.model.AIError error) {
        // Handle the error
    }
}