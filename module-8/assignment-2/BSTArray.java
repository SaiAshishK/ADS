class BSTArray {
    int[] keys = new int[150];
    int[] leftKey = new int[150];
    int[] rightKey = new int[150];

    BSTArray() {
        for (int i = 0; i < leftKey.length; i++) {
            leftKey[i] = -1;
        }
        for (int i = 0; i < rightKey.length; i++) {
            rightKey[i] = -1;
        }
        for (int i = 0; i < keys.length; i++) {
            keys[i] = -619;
        }
    }

    void insert(int key) {
        if (keys[1] == -619) {
            keys[1] = key;
        } else {
            int i = 1;
            while (i < keys.length) {
                if (keys[i] < key) {
                    if (keys[(2 * i) + 1] == -619) {
                        keys[(2 * i) + 1] = key;
                        rightKey[i] = (2 * i) + 1;
                        break;
                    } else {
                        i = (2 * i) + 1;
                    }
                } else if (keys[i] > key) {
                    if (keys[(2 * i)] == -619) {
                        keys[(2 * i)] = key;
                        leftKey[i] = (2 * i);
                        break;
                    } else {
                        i = (2 * i);
                    }
                }
            }
        }
    }

    void delete(int k) {
        delete(k, 1);
    }

    void delete(int k, int init) {
        int i = init;
        int right = 0;
        int left = 0;
        int deleteFlag = 0;
        int deletePresent = keys[k];
        while (i < keys.length) {
            if (keys[i] == -619) {
                System.out.println("No element found");
                break;
            } else {
                if (k > keys[i]) {
                    i = (2 * i) + 1;
                    right = 1;
                    left = 0;
                } else if (k < keys[i]) {
                    i = 2 * i;
                    left = 1;
                    right = 0;
                } else {
                    if ((keys[2 * i] == -619) && (keys[(2 * i) + 1] == -619)) {
                        keys[i] = -619;
                        deleteFlag = 1;
                        break;
                    } else if (keys[2 * i] == -619) {
                        keys[i] = keys[(2 * i) + 1];
                        if (left == 0) {
                            rightKey[i / 2] = (2 * i) + 1;
                        } else if (right == 0) {
                            leftKey[i / 2] = (2 * i) + 1;
                        }
                        deletePresent = (2 * i) + 1;
                        break;
                    } else if (keys[(2 * i) + 1] == -619) {
                        i = 2 * i;
                        if (left == 0) {
                            rightKey[i / 2] = (2 * i);
                        } else if (right == 0) {
                            leftKey[i / 2] = (2 * i);
                        }
                        deletePresent = (2 * i);
                        break;
                    } else {
                    }
                }
            }
        }
        if (deleteFlag == 0) {
            delete(keys[deletePresent], deletePresent);
        }

    }

    void print() {
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]);
        }
    }

    public static void main(String[] args) {
        BSTArray b = new BSTArray();
        b.insert(10);
        b.insert(9);
        b.insert(8);
        b.insert(7);
        b.insert(6);
        b.insert(5);
        b.insert(4);
        b.delete(4);
        b.print();
    }
}