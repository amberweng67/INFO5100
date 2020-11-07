public class HospitalRoom {
    int doctorNumber = 0;
    int patientNumber = 0;
    private final Object doctorLock = new Object();
    private final Object patientLock = new Object();

    public boolean doctorEnter(Doctor d) throws InterruptedException {
        synchronized (doctorLock) {
            if (doctorNumber > 0) {
                System.out.format("Doctor %s is waiting to enter , number of doctor %d\n", d.name, this.doctorNumber);
                doctorLock.wait();
                return false;
            }
            this.doctorNumber++;
            System.out.format("Doctor %s Entered , number of doctor %d\n", d.name, this.doctorNumber);
            doctorLock.notify();
            return true;
        }
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        synchronized (doctorLock) {
            this.doctorNumber--;
            System.out.format("Doctor %s left , number of doctor %d\n", d.name, this.doctorNumber);
            doctorLock.notify();
            return true;
        }
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        synchronized (patientLock) {
            if (this.patientNumber >= 3) {
                System.out.format("Patient %s is waiting to enter , number of patient %d\n", p.name, this.patientNumber);
                patientLock.wait();
                return false;
            }

            this.patientNumber++;
            System.out.format("Patient %s Entered , number of patient %d\n", p.name, this.patientNumber);
            this.patientLock.notify();
            return true;
        }
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        synchronized (patientLock) {
            this.patientNumber--;
            System.out.format("Patient %s left , number of patient %d\n", p.name, this.patientNumber);
            this.patientLock.notify();
            return true;
        }
    }

}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
}