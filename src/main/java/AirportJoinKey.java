import edu.umd.cs.findbugs.annotations.NonNull;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportJoinKey implements WritableComparable<AirportJoinKey> {
    private int airportId;
    private boolean isFlight;

    AirportJoinKey(int airportId, boolean isFlight) {
        this.airportId = airportId;
        this.isFlight = isFlight;
    }

    AirportJoinKey() {
    }

    public int getAirportId() {
        return airportId;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportId);
        dataOutput.writeBoolean(isFlight);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        airportId = dataInput.readInt();
        isFlight = dataInput.readBoolean();
    }

    @Override
    public int compareTo(@NonNull AirportJoinKey o) {
        return airportId != o.airportId
                ? airportId - o.airportId
                : Boolean.compare(isFlight, o.isFlight);
    }
}
