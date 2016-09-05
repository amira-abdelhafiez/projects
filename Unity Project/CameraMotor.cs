using UnityEngine;
using System.Collections;

public class CameraMotor : MonoBehaviour {
	private Transform lookAT;
	private Vector3 startOffset;
	private Vector3 moveVector;
	private float transition = 0.0f;
	private float animationDuration = 3.0f;
	private Vector3 animationOffset = new Vector3(0,3,3);
	// Use this for initialization
	void Start () {
		lookAT = GameObject.FindGameObjectWithTag ("Player").transform;
		startOffset = transform.position - lookAT.position;
	}
	
	// Update is called once per frame
	void Update () {
		moveVector = lookAT.position + startOffset;
		moveVector.x = 0;
		moveVector.y = Mathf.Clamp (moveVector.y, 2, 2);
		if (transition > 1.0f) {
			transform.position = moveVector;
		} else {
			transform.position = Vector3.Lerp (moveVector + animationOffset, moveVector, transition);
			transition += Time.deltaTime * 1 / animationDuration;
			transform.LookAt (lookAT.position + Vector3.up);
		}

	}
}
