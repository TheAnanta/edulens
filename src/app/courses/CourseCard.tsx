"use client";
import { useRouter } from "next/navigation";
export default function CourseCard(props: {
  title: string;
  attribute: string;
}) {
  const router = useRouter();
  return (
    <div className="bg-[var(--secondary-color)] p-6 w-full rounded-3xl flex-col items-center justify-between space-y-6">
      <div>
        <p className="text-lg">{props.title}</p>
        <p className="text-sm">{props.attribute}</p>
      </div>

      <div className="flex justify-end items-center space-x-2">
        <button
          onClick={() => {
            router.push("/courses/" + props.title);
          }}
          className="bg-[var(--main-color)] border rounded-3xl text-white px-4 py-2 text-sm font-medium"
        >
          View
        </button>
      </div>
    </div>
  );
}
