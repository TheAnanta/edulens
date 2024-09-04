"use client";
import { useRouter } from "next/navigation";
import { Button } from "@mui/material";
export default function CourseCard(props: {
  title: string;
  attribute: string;
}) {
  const router = useRouter();
  return (
    <div className="bg-[var(--secondary-color)] p-6 w-full rounded-3xl flex-col items-center justify-between space-y-6">
      <div>
        <p className="text-2xl font-bold">{props.title}</p>
        <p className="text-sm font-semibold">{props.attribute}</p>
      </div>
      <p>
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Placeat iure,
        accusamus aperiam beatae rem culpa veritatis omnis deleniti repellat
        cumque blanditiis voluptas autem labore eum quae sit eos! Minima, ipsam!
      </p>
      <div className="flex justify-end items-center space-x-2">
        <Button
          variant="contained"
          onClick={() => {
            router.push("/courses/" + props.title);
          }}
          className="bg-[var(--main-color)] w-full"
        >
          View
        </Button>
      </div>
    </div>
  );
}
