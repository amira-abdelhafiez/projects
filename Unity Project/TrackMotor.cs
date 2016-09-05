using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class TrackMotor : MonoBehaviour {
	private Transform PlayerTransform;
	public GameObject[] trackPrefabs;
	private float spawnZ = -3.8f;
	private float trackLen = 7.6f;
	private int amn = 9;
	private List<GameObject> activeTracks;
	private int lastPrefabIndex = 0;


	// Use this for initialization
	private void Start () {
		PlayerTransform = GameObject.FindGameObjectWithTag ("Player").transform;
		activeTracks = new List<GameObject>();
		SpawnTrack (0);
	    for (int i = 0; i < amn; i++) {
			if (i <= 2)
				SpawnTrack (0);
			else
				SpawnTrack ();
		}
	}
	
	// Update is called once per frame
	private void Update () {
		if (PlayerTransform.position.z > (spawnZ - amn * trackLen)) {
			SpawnTrack ();
			DeleteTrack ();
		}

	}

	private void SpawnTrack(int prefabIndex = -1){
		GameObject go;
		if (prefabIndex == -1)
			go = Instantiate (trackPrefabs [RandomPrefabIndex ()]) as GameObject;
		else
			go = Instantiate (trackPrefabs [prefabIndex]);
		go.transform.SetParent (transform);
		go.transform.position = Vector3.forward * spawnZ;
		spawnZ += trackLen;
		activeTracks.Add (go);
	}

	private void DeleteTrack(){
		Destroy (activeTracks [0]);
		activeTracks.RemoveAt (0);
	}

	private int RandomPrefabIndex(){
		if (trackPrefabs.Length <= 1) {
			return 0;
		}
		int randomIndex = lastPrefabIndex;
		while (randomIndex == lastPrefabIndex) {
			randomIndex = Random.Range (0,trackPrefabs.Length);
		}
		lastPrefabIndex = randomIndex;
		return randomIndex;
			
	}
}
