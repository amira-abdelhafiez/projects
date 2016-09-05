using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class MainMenu : MonoBehaviour {

	public Text BestTime;
	public Text BestPoints;

	// Use this for initialization
	void Start () {
		BestTime.text = ((int)PlayerPrefs.GetFloat ("TimeHighScore")).ToString ();
		BestPoints.text = PlayerPrefs.GetInt ("PointsHighScore").ToString ();
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	public void ToGame(){
		SceneManager.LoadScene ("Game");
	}
	public void LeaveGame(){
		Application.Quit ();
	}
}
