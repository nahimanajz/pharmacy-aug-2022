import { Link, useLocation } from "react-router-dom";
import { Record } from "../components/Record";

export function Info() {
  const { state: records } = useLocation();
  return (
    <>
      <Link to="/" style={{ position: "fixed", top: 0, left: 0 }}>
        <span>
          <i className="fa fa-arrow-left"></i>
        </span>
      </Link>
      <div className="table-container">
        {records && Object.keys(records.data).length === 3 ? ( // Meabs admin and he has to see everything
          <>
            <Record
              data={records.data["Patient illnesses 2000 - 2002"]}
              title={"Patient illnesses 2000 - 2002"}
            />
            <Record
              data={records.data["Physicians missions 2000 - 2002"]}
              title={"Physicians missions 2000 - 2002"}
            />
            <Record
              data={records.data["Most bough drugs 2000 - 2002"]}
              title={"Most bough drugs 2000 - 2002"}
            />
          </>
        ) : (
          // check and populate the title
          <Record data={records?.data} title={records?.title} />
        )}
      </div>
    </>
  );
}
