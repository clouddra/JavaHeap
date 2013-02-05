class Woman implements Comparable<Woman> {

	String name;
	double dilationStatus;
	int qNo; // queue no.

	Woman(String name, double dilationStatus, int qNo) {
		this.name = name;
		this.dilationStatus = dilationStatus;
		this.qNo = qNo;
	}

	Woman() {
		this.name = null;
		this.dilationStatus = 0;
	}

	public int compareTo(Woman other) {

		if (this.dilationStatus != other.dilationStatus)
			return (this.dilationStatus > other.dilationStatus) ? 1 : -1;

		return other.qNo - this.qNo ; // use q no only if same dilation
										// smaller the qNo, "larger" the node is
	}
}