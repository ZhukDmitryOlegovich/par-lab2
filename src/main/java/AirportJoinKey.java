import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportJoinKey implements WritableComparable<AirportJoinKey> {
    private int airportId;
    private byte isAirport;

    AirportJoinKey(int airportId, byte isAirport) {
        this.airportId = airportId;
        this.isAirport = isAirport;
    }

    public int getAirportId() {
        return airportId;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportId);
        dataOutput.writeByte(isAirport);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        airportId = dataInput.readInt();
        isAirport = dataInput.readByte();
    }

    @Override
    public int compareTo(AirportJoinKey o) {
        return airportId != o.airportId ? airportId - o.airportId : isAirport - o.isAirport;
    }
}
