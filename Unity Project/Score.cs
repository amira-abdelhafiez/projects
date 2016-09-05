using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class Score : MonoBehaviour {

	private float timeScore = 0.0f;
	private int pointsScore = 0;
	public Text scoreText;
	private int difficultyLevel = 1;
	private int maxDifficultyLevel = 10;
	private int scoreToNextLevel = 10;
	private bool isDead = false;
	public DeathMenu deathMenu;
	// Use this for initialization
	void Start () {
	}
	
	// Update is called once per frame
	void Update () {
		pointsScore = GetComponent<Player> ().GetPickupScore ();
		if (isDead)
			return;
		if (timeScore >= scoreToNextLevel)
			LevelUp ();
		timeScore  += Time.deltaTime;
		scoreText.text = ((int)timeScore ).ToString ();
	}
	void LevelUp(){
		if (difficultyLevel == maxDifficultyLevel)
			return;
		scoreToNextLevel *= 2;
		difficultyLevel++;

		GetComponent<Player> ().SetSpeed (difficultyLevel);
		Debug.Log (difficultyLevel);
	}

	public void OnDeath(){
		isDead = true;
		if(PlayerPrefs.GetFloat("TimeHighScore") < timeScore)
			PlayerPrefs.SetFloat ("TimeHighScore",timeScore);
		if(PlayerPrefs.GetInt("PointsHighScore") < pointsScore)
			PlayerPrefs.SetInt ("PointsHighScore", pointsScore);
		deathMenu.ToggleEndMenu (timeScore,pointsScore);
	}
}
