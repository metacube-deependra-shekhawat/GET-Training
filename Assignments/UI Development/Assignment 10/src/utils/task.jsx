import { useState } from "react";
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';

function Task(props){
    const bgColors = ["#8CC152","#37BC9B","#E9573F"];
    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);
    

    return (
        <>
            <div onClick={handleOpen} className="taskTile" style={{backgroundColor: bgColors[props.priority]}}>
                <p className="taskTitle">{props.title}</p>
                <p className="taskDesc">{props.desc}</p>
            </div>
            <Modal open={open} onClose={handleClose}>
                <Box id="modalStyle">
                    <p>Update Your Task</p>
                    <input type="text" placeholder="Task Name"></input>
                    <input type="text" placeholder="Task Description"></input>
                    <div>
                        <label>Status</label>
                        <input type="radio" value="new" name="taskStatus"></input>
                        <label>New</label>
                        <input type="radio" value="in-progress" name="taskStatus"></input>
                        <label>In-progress</label>
                        <input type="radio" value="completed" name="taskStatus"></input>
                        <label>Completed</label>
                    </div>
                    <br/>
                    <div>
                        <button>Save Task</button>
                        <button onClick={handleClose}>Cancel</button>
                    </div>
                </Box>
            </Modal>
        </>
    )
}

export default Task;