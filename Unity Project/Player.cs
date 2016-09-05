using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class Player : MonoBehaviour {
	private float speed = 5.0f;
	private CharacterController controller;
	private Vector3 moveVector;
	private float animationDuration = 3.0f;
	public int PickupScore = 0;
	public Text scorePickup;
	private bool isDead = false;
	public Animator anim;
	private float startTime;

	// Use this for initialization
	void Start () {
		controller = GetComponent<CharacterController> ();
		anim.GetComponent<Animator>();
		scorePickup.text = PickupScore.ToString ();
		startTime = Time.time;
	}
	
	// Update is called once per frame
	void Update () {
		if (isDead)
			return;
		if (transform.position.y < -3)
			Death ();
		if (Time.time - startTime < animationDuration) {
			controller.Move (Vector3.forward * speed * Time.deltaTime);
			return;
		}
		moveVector = Vector3.zero;
		moveVector.x = Input.GetAxisRaw ("Horizontal") * speed;
		moveVector.z = speed;
		controller.Move (moveVector * Time.deltaTime);
		scorePickup.text = PickupScore.ToString ();
	}
		
	public void SetSpeed(float modifier){
		speed = 5.0f + modifier;
	}

	private void OnControllerColliderHit(ControllerColliderHit hit){
		if (hit.gameObject.tag == "Pickup") {
			hit.gameObject.SetActive (false);
			PickupScore++;
		} else if (hit.gameObject.tag == "Hurdle") {
			Death ();
		}
	}

	private void Death(){
		isDead = true;
		GetComponent<Score> ().OnDeath ();
		anim.Play ("DAMAGED01",-1,0f);
		//anim.Play ("DAMAGED00", -1, 0f);
	}
	public int GetPickupScore(){
		return PickupScore;
	}
}
