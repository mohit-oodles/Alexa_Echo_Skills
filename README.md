Setup Interaction Model

1. First, you'll need to signup for Amazon Developer account. Sign in to https://developer.amazon.com/

2. Once you signup, you'll need login at https://developer.amazon.com/alexa/console/ask

3. Now Click on Create Skill.

4. Enter Skill Name "FblAlexAsisstant".

5. Choose a model to add to your skill, in our case it would be the Custom skill. Click Choose

6. Choose a template, we'll select "Start from Scratch" and click Choose.

7. Now, you'll be redirected to Skill Builder. here you can configure the skill and that's what we'll do now.

8. Now, we'll configure our Interaction Model on left panel provide an invocation name. This name will be used by Alexa to open your skill.
 So, we'll use "customer support" as our invocation name. For reference visit: https://developer.amazon.com/docs/custom-skills/choose-the-invocation-name-for-a-custom-skill.html

9. You'll see some default Intents are created.

10. Now, copy models/en-US.json and paste it in JSON editor. This will configure your skill.

11. In the Endpoint tab provide the ARN from your AWS lambdas.

Done!