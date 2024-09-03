import DownloadIcon from "@mui/icons-material/Download";
import { Button } from "@mui/material";

export default function Form() {
  return (
    <div className="p-8 rounded-2xl bg-[var(--secondary-color)] h-max">
      <h1 className="font-semibold mb-4">Forms</h1>
      <p className="mb-4">
        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Consequuntur
        cumque atque odio blanditiis tempora architecto nostrum, repellendus
        optio quas praesentium reprehenderit placeat repellat quos est eum
        voluptas natus qui cupiditate.
      </p>
      <div className="flex w-full items-center justify-between p-4 border-b border-[var-(--main-color)]">
        <h2>Application Form</h2>
        <DownloadIcon />
      </div>
      <div className="flex w-full items-center justify-between p-4 border-b border-[var-(--main-color)]">
        <h2>Application Form</h2>
        <DownloadIcon />
      </div>
      <div className="flex w-full items-center justify-between p-4">
        <h2>Application Form</h2>
        <DownloadIcon />
      </div>
      <Button variant="outlined">Apply Now</Button>
    </div>
  );
}
