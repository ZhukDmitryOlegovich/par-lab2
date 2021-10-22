import edu.umd.cs.findbugs.annotations.NonNull;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportJoinKey implements WritableComparable<AirportJoinKey> {
    private int airportId;
    private boolean isAirport;

    AirportJoinKey(int airportId, boolean isAirport) {
        this.airportId = airportId;
        this.isAirport = isAirport;
    }

    AirportJoinKey() {}

    public int getAirportId() {
        return airportId;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportId);
        dataOutput.writeBoolean(isAirport);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        airportId = dataInput.readInt();
        isAirport = dataInput.readBoolean();
    }

    @Override
    public int compareTo(@NonNull AirportJoinKey o) {
        return 0;
//        return airportId != o.airportId
//                ? airportId - o.airportId
//                : Boolean.compare(isAirport, o.isAirport);
    }
}
