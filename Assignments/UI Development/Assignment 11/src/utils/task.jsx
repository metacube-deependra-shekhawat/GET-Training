import { useState } from "react";
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';

function Task(props){
    const bgColors = ["#8CC152","#37BC9B","#E9573F"];
    const [open, setOpen] = useState(false);
    const [tname, setTname] = useState("");
    const [tdesc, setTdesc] = useState("");
    const [tstatus, setTstatus] = useState(-1);
    const [tpriority, setTpriority] = useState(-1);
    const handleOpen = () => {
        if(props.status == 2) return;
        setTname(props.title);
        setTdesc(props.desc);
        setTpriority(props.priority);
        setTstatus(props.status);
        setOpen(true);
    }
    const handleClose = () => setOpen(false);
    const handleTitleChange = (event) => {
        setTname(event.target.value);
    }
    const handleDescChange = (event) => {
        setTdesc(event.target.value);
    }
    const handleDelete = () => {
        console.log(props.id);
        props.deleteTask(props.id);
        handleClose();
    }
    const handleUpdate = () => {
        let newTask = {
            taskId: props.id,
            title: tname,
            desc: tdesc,
            priority: tpriority,
            status: tstatus,
        }
        props.updateTask(newTask);
        handleClose();
    }

    return (
        <>
            <div onClick={handleOpen} className="taskTile" style={{backgroundColor: bgColors[props.priority]}}>
                <p className="taskTitle">{props.title}</p>
                <p className="taskDesc">{props.desc}</p>
            </div>
            <Modal open={open} onClose={handleClose}>
                <Box id="modalStyle">
                    <p>Update Your Task</p>
                    <div className="inputs">
                        <label>Title</label>
                        <input type="text" value={tname} onChange={handleTitleChange}></input>
                        <label>Description</label>
                        <input type="text" value={tdesc} onChange={handleDescChange}></input>
                    </div>
                    <div>
                        <label>Status:</label>
                        <span> </span>
                        <input type="radio" value="new" name="taskStatus" onChange={() => setTstatus(0)}></input>
                        <label>New</label>
                        <span> </span>
                        <input type="radio" value="in-progress" name="taskStatus" onChange={() => setTstatus(1)}></input>
                        <label>In-progress</label>
                        <span> </span>
                        <input type="radio" value="completed" name="taskStatus" onChange={() => setTstatus(2)}></input>
                        <label>Completed</label>
                    </div>
                    <div>
                        <label>Priority:</label>
                        <span> </span>
                        <input type="radio" value="2" name="taskpriority" onChange={() => setTpriority(2)}></input>
                        <label>high</label>
                        <span> </span>
                        <input type="radio" value="1" name="taskpriority" onChange={() => setTpriority(1)}></input>
                        <label>medium</label>
                        <span> </span>
                        <input type="radio" value="0" name="taskpriority" onChange={() => setTpriority(0)}></input>
                        <label>low</label>
                    </div>
                    <br/>
                    <div>
                        <button onClick={handleUpdate}>Update Task</button>
                        <span> </span>
                        <button onClick={handleClose}>Cancel</button>
                        <span> </span>
                        <button onClick={handleDelete}>Delete</button>
                    </div>
                </Box>
            </Modal>
        </>
    )
}

export default Task;