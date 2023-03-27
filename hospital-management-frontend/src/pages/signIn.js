
import { useNavigate } from "react-router";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import {
  Container,
  Form,
  Button,
  Row,
  Col,
  Dropdown,
  DropdownButton,
  SplitButton,
  ButtonGroup,
  Image,
} from "react-bootstrap";
import "../components/full.css";
import { Link } from "react-router-dom";
import CreateCorosol from "../components/corosol";
import img1 from "../assets/corosole1.jpeg";
import { getUser } from "../data";
import axios from "axios";
import { URL } from "../config";
import "./signIn.css";
import WardDropdownElement from "../components/patient/wardDropdownElement";
import WardTableSignIn from "../components/signin/wardTable";

const SignIn = () => {
  const [role, setRole] = useState("Select Role");
  const [email, setEmail] = useState("enter your emai");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  //wards relatedconst [wardId, setWardId] = useState(0);

  const [wards, setWards] = useState([]);
  let user;

  /*****==========================get wards from server=================================================== */
  const GetWardsFromServer = () => {
    const url = `${URL}/ward/getAllWards`;
    axios.get(url).then((res) => {
      const result = res.data;
      console.log(result);
      if (result.status == "success") setWards(result.data);
    }).catch(err => {
      navigate("/error");
    });
  };
  // --------------------------------------------------------------------------
  const getUserFromServer = () => {
    console.log("email" + email + "   password" + password + "  role :" + role);
    const body = {
      email,
      password,
      role,
    };

    const url = `${URL}/user/authenticate`;
    axios.post(url, body).then((req) => {
      console.log(req);
      let result = req.data;

      if (
        result.data != "invalid_user" &&
        result.data != "invalid_password" &&
        result.status == "success"
      ) {

        user = result.data;
        sessionStorage.setItem(`token_${user.role}`, result.data.token);
        const token = sessionStorage.getItem("token_admin");

        if (role == user.role) {
          if (role == "patient") {
            toast.success("logged in success", {
              position: toast.POSITION.TOP_CENTER,
            });
            navigate("/patientDetails", { state: { patId: user.patId } });
          }
          if (role == "admin") {
            console.log("in admin");
            toast.success("logged in success", {
              position: toast.POSITION.TOP_CENTER,
            });
            navigate("/admin");
          }
          if (role == "reception") {
            toast.success("logged in success", {
              position: toast.POSITION.TOP_CENTER,
            });
            navigate("/reception", { state: { patId: user.patId } });
          }
          if (role == "doctor") {
            toast.success("logged in success", {
              position: toast.POSITION.TOP_CENTER,
            });
            navigate("/doctor", { state: { doctorId: user.doctorId } });
          }
          //for signin if it is accountant
          if (role == "accountant") {
            toast.success("logged in success", {
              position: toast.POSITION.TOP_CENTER,
            });
            navigate("/accountant");
          }
        } else {
          navigate("/");
          toast.warning("invalid role selected", {
            position: toast.POSITION.TOP_CENTER,
          });
        }
      } else {
        if (result.data == "invalid_password") {
          navigate("/");
          toast.warning("invalid password", {
            position: toast.POSITION.TOP_CENTER,
          });
        } else {
          navigate("/");
          toast.warning("invalid email", {
            position: toast.POSITION.TOP_CENTER,
          });
        }
      }
    }).catch(err => {
      navigate("/error");
    });
  };
  useEffect(() => {
    GetWardsFromServer();
  }, []);
  return (
    <Container fluid style={{ height: "100%", width: "100%" }}>
      <Container
        fluid
        className="d-flex justify-content-center corosoleContainer"
      >
        <Row>
          <Col>
            <div>
              <CreateCorosol />
            </div>
          </Col>
          <Col>
            {" "}
            <div style={{ marginLeft: "20px", marginRight: "20px" }}>
              <CreateCorosol />
            </div>
          </Col>
          <Col>
            {" "}
            <div>
              <CreateCorosol />
            </div>
          </Col>
        </Row>
      </Container>
      <br />
      {/* /**------zz--------------------------------------------------- */}
      <Row>
        <Col style={{marginTop:"75px", marginLeft:"50px"}}>
          <div className="Info" style={{ float: "right", marginLeft:"30px" , marginTop:"30px"  }}>

            <h1 style={{ color: "black" }}>
              HMS Hospital
            </h1>
            <h2 style={{ color: "black" }}>
              Stay Safe, Stay Healthy
            </h2>
            <h5 style={{ color: "black" }}>
              <a href="mailTo:aakash.virdhe@gmail.com" style={{ color: "black" }} >aakash.virdhe@gmail.com</a>
              <br />
              <a href="mailTo:oanvekar.oa@gmail.com" style={{ color: "black" }} >oanvekar.oa@gmail.com</a>
            </h5>
          </div>
          <div style={{ float: "left" }}>
            <table
              className="table table-hover center"
              style={{ margin: "20px", border: "solid", borderRadius: "30px" , width:"230px" }}
            >
              <thead style={{ backgroundColor: "cadetBlue" }}>
                <tr>
                  <th>Ward type</th>
                  <th>Beds Available</th>
                  <th>Max Capacity</th>
                </tr>
              </thead>
              <tbody className="tableBody" style={{ backgroundColor: "White" }}>
                {wards.map((ward) => {
                  return <WardTableSignIn ward={ward} />;
                })}
              </tbody>
            </table>
          </div>

        </Col>
        <Col>
          <Container
            fluid
            className="d-flex justify-content-center signInContainer"
          >
            <Row>
              <Col>
                {/* /**==================drop down role=============================== */}
                <div style={{ marginTop: "15px" }}>
                  <DropdownButton size="md" title={role} variant="primary">
                    <Dropdown.Item as="Button">
                      <div
                        id="setAdmin"
                        onClick={(e) => {
                          setRole(e.target.innerText);
                        }}
                      >
                        admin
                      </div>
                    </Dropdown.Item>
                    <Dropdown.Item>
                      <div
                        id=""
                        onClick={(e) => {
                          setRole(e.target.innerText);
                        }}
                      >
                        accountant
                      </div>
                    </Dropdown.Item>
                    <Dropdown.Item>
                      <div
                        onClick={(e) => {
                          setRole(e.target.innerText);
                        }}
                      >
                        reception
                      </div>
                    </Dropdown.Item>
                    <Dropdown.Item>
                      <div
                        onClick={(e) => {
                          setRole(e.target.innerText);
                        }}
                      >
                        patient
                      </div>
                    </Dropdown.Item>
                    <Dropdown.Item>
                      <div
                        onClick={(e) => {
                          setRole(e.target.innerText);
                        }}
                      >
                        doctor
                      </div>
                    </Dropdown.Item>
                  </DropdownButton>
                </div>

                {/* /*****===============zzz=zzz============================== */}
                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <Form.Label>
                    <div style={{ fontSize: "25px", fontWeight: "bold", color: "black" }}>
                      Email address
                    </div>{" "}
                  </Form.Label>
                  <Form.Control
                    style={{ border: "solid", borderColor: "grey", borderRadius: "3px" }}
                    onChange={(e) => {
                      setEmail(e.target.value);
                    }}
                    type="email"
                    placeholder="Enter email"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>
                    <div style={{ fontSize: "25px", fontWeight: "bold", color: "black" }}>
                      Password
                    </div>
                  </Form.Label>
                  <Form.Control
                    style={{ border: "solid", borderColor: "grey", borderRadius: "3px" }}
                    onChange={(e) => {
                      setPassword(e.target.value);
                    }}
                    type="password"
                    placeholder="Password"
                  />
                </Form.Group>

                <div
                  style={{ marginTop: "20px", fontSize: "20px" }}
                  className="position-relative"
                >
                  <div style={{ marginTop: "18px" }}>
                    <Button
                      variant="success"
                      size="md"
                      type="submit"
                      onClick={() => {
                        getUserFromServer();
                      }}
                    >
                      <div style={{ fontSize: "20px" }}>Login</div>
                    </Button>
                  </div>
                  <div style={{ marginTop: "20px", marginTop: "10px" }}>
                    <Link to="/resetPassword">
                      <div style={{ fontSize: "25px", fontWeight: "bold", color: "black" }}>
                        Forgot Password
                      </div>
                    </Link>
                  </div>
                </div>
              </Col>
            </Row>
          </Container>
        </Col>

      </Row>
    </Container>
  );
};
export default SignIn;
